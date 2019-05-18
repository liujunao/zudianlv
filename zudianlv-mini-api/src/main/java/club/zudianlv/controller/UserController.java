package club.zudianlv.controller;

import club.zudianlv.config.ResourceConfig;
import club.zudianlv.pojo.*;
import club.zudianlv.pojo.vo.RentVO;
import club.zudianlv.pojo.vo.UserAppend;
import club.zudianlv.pojo.vo.UserVO;
import club.zudianlv.pojo.vo.WxResult;
import club.zudianlv.service.*;
import club.zudianlv.utils.HttpClientUtil;
import club.zudianlv.utils.JsonUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author yinren
 * @date 2019/5/1
 */
@RestController
@RequestMapping("/user")
public class UserController extends BasicController {

    @Autowired
    private ResourceConfig resourceConfig;
    @Autowired
    private UserService userService;
    @Autowired
    private RentService rentService;
    @Autowired
    private RentTimeService rentTimeService;
    @Autowired
    private PublishService publishService;
    @Autowired
    private UsedService usedService;

    //首次登陆时，进行注册操作
    @PostMapping("/wxRegister")
    public User wxRegister(@RequestBody UserVO userVO) {
        if (StringUtils.isBlank(userVO.getCode())) {
            return new User("-1"); //未收到前端传值，返回 -1
        }
        WxResult wx = getWX(userVO.getCode());//获取 openid 与 session_key
        if (StringUtils.isBlank(wx.getOpenid())) {
            return new User("-1"); //未获取到 openid，返回 -1
        }
        String userIsExist = userService.getIdAndSession(wx.getOpenid());
        User user;
        if (StringUtils.isBlank(userIsExist)) {//不存在该用户，进行注册
            System.out.println(userIsExist);
            user = new User(wx.getOpenid(), wx.getSession_key(), userVO.getNickName(), userVO.getGender(), userVO.getAvatarUrl(), 0, 0);
            userService.saveRegister(user);//将用户信息保存到数据库
            setUserRedis(wx);//将 openid 与 session_key 保存到 redis 中
        } else {//该用户已存在
            //用户信息更新
            User wxUser = new User(wx.getOpenid(), wx.getSession_key(), userVO.getNickName(), userVO.getGender(), userVO.getAvatarUrl());
            userService.updateWxUser(wxUser);
            user = userService.getUser(wx.getOpenid());
        }
        user.setSessionKey(""); //不把 session_key 传给前端
        return user;
    }

    //用户信息修改后的登陆
    @PostMapping("/wxLogin")
    public User wxLogin(String code) {
        WxResult wx = getWX(code);
        String redisSessionKey = redisOperator.get(wx.getOpenid());
        if (redisSessionKey != null) {//用户信息未改变且在redis中保存
            return userService.getUser(wx.getOpenid());
        } else {//redis 中未保存或过期
            String session = userService.getIdAndSession(wx.getOpenid());//从数据库中获取 session_key
            if (session.equals(wx.getSession_key())) {//session_key 相同
                setUserRedis(wx);//再次保存到 redis 中
                return userService.getUser(wx.getOpenid());
            } else {
                return new User("-1");
            }
        }
    }

    //完善用户信息
    @PostMapping("/append")
    public User wxAppend(@RequestBody UserAppend userAppend) {
        if (StringUtils.isBlank(userAppend.getOpenId())) {
            return new User("-1");
        } else {
            int appendUser = userService.appendUser(userAppend);
            if (appendUser == 0) {
                return new User("-1");
            } else {
                User user = userService.getUser(userAppend.getOpenId());
                user.setSessionKey(""); //不把 session_key 传给前端
                return user;
            }
        }
    }

    //上传学生证照片
    @PostMapping("/upload")
    public User upload(String openId, @RequestParam("hust") MultipartFile[] files) throws IOException {
        if (StringUtils.isBlank(openId)) {
            return new User("-1");
        }
        //保存到数据库中的相对路径
        String uploadPathDB = "/" + openId;

        String uploadImg = uploadImg(openId, files, uploadPathDB);//图片保存
        if (uploadImg.equals("-1")) {
            return new User("-1");
        } else {
            uploadPathDB += "/" + uploadImg;
        }
        User uploadUser = new User(openId, uploadPathDB);
        userService.uploadHust(uploadUser);

        return userService.getUser(openId);
    }

    //我的出租信息
    @RequestMapping("/rent/list")
    public RentVO rentList(String openId) {
        Rent rent = rentService.getRentByOpenId(openId);
        if (rent != null) {
            //获取 rentTime 信息
            List<RentTime> rentTimeByOpenId = rentTimeService.getRentTimeByOpenId(openId);
            return new RentVO(rent, rentTimeByOpenId);
        } else {
            return new RentVO(new Rent("-1"));
        }
    }

    //出租信息添加/修改
    @RequestMapping("/rent/add")
    public RentVO rentAdd(@RequestBody RentVO rentVO) {
        if (StringUtils.isBlank(rentVO.getRent().getOpenId())) {
            return new RentVO(new Rent("-1"));
        } else {
            List<RentTime> rentTimes = rentVO.getRentTime();
            //判断 RentTime 是否已有指定 openId 的值
            List<RentTime> rentTimeByOpenId = rentTimeService.getRentTimeByOpenId(rentVO.getRent().getOpenId());
            if (rentTimeByOpenId != null) {//已有，则删除
                rentTimeService.deleteByOpenId(rentVO.getRent().getOpenId());
            }
            rentTimeService.addRentTime(rentTimes, rentVO.getRent().getOpenId());//插入

            //获取 week 信息，方便筛选
            String rentWeek = "";
            for (RentTime rentTime : rentTimes){
                rentWeek += String.valueOf(rentTime.getWeek()) + ",";
            }

            //rent 信息添加
            Rent rent = new Rent(rentVO.getRent().getOpenId(), rentVO.getRent().getMoney(), rentVO.getRent().getManned(), rentWeek, Long.toString(new Date().getTime()), rentVO.getRent().getNickName(),
                    rentVO.getRent().getGender(), rentVO.getRent().getAvatarUrl(), rentVO.getRent().getArea(), rentVO.getRent().getAreaNum(), rentVO.getRent().getWeixin(), rentVO.getRent().getRent(), rentVO.getRent().getMessage());
            int addRent = rentService.addRent(rent);//修改或添加
            if (addRent == -1) {
                return new RentVO(new Rent("-1"));
            } else {
                Rent rentTmp = rentService.getRentByOpenId(rentVO.getRent().getOpenId());
                List<RentTime> rentTimeTmp = rentTimeService.getRentTimeByOpenId(rentVO.getRent().getOpenId());
                return new RentVO(rentTmp, rentTimeTmp);
            }
        }
    }

    //上传出租车辆图片
    @RequestMapping("/rent/addCar")
    public Rent rentAddCarImage(String openId, @RequestParam("car") MultipartFile[] files) throws IOException {
        if (StringUtils.isBlank(openId)) {
            return new Rent("-1");
        }
        //保存到数据库中的相对路径
        String uploadPathDB = "/" + openId;
        String uploadImg = uploadImg(openId, files, uploadPathDB);//上传图片到文件夹
        if (uploadImg.equals("-1")) {
            return new Rent("-1");
        } else {
            uploadPathDB += "/" + uploadImg;
        }
        rentService.uploadCar(openId, uploadPathDB);//上传，同时判断是否已经存在
        return rentService.getRentByOpenId(openId);
    }

    //返回我的求租列表
    @RequestMapping("/publish/list")
    public List<Publish> publishList(String openId) {
        if (StringUtils.isBlank(openId)) {
            List<Publish> list = new ArrayList<>();
            list.add(new Publish("-1"));
            return list;
        } else {
            List<Publish> publishList = publishService.publishListByOpenId(openId);
            return publishList;
        }
    }

    //删除我的求租信息
    @RequestMapping("/publish/delete")
    public Publish deletePublish(String publishId, String openId) {
        publishService.deleteById(publishId, openId);
        return new Publish(openId);
    }

    //查看指定 openId 的二手车信息
    @RequestMapping("/used/list")
    public Used usedList(String openId) {
        Used usedByOpenId = usedService.getUsedByOpenId(openId);
        return usedByOpenId;
    }

    //修改或添加二手车信息
    @RequestMapping("/used/change")
    public Used changeUsed(Used used) {
        Used usedByOpenId = usedService.getUsedByOpenId(used.getOpenId());
        if (usedByOpenId != null) {
            int updateUsed = usedService.updateUsed(used);
            if (updateUsed > 0) {
                return used;
            } else {
                return new Used("-1");
            }
        } else {
            usedService.addUsed(used);
            return usedService.getUsedByOpenId(used.getOpenId());
        }
    }

    //上传图片
    private String uploadImg(String openId, MultipartFile[] files, String uploadPathDB) throws IOException {
        //文件保存位置
        String fileSpace = resourceConfig.getFileSpace();

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        String fileName = "";
        try {
            if (files != null && files.length > 0) {
                fileName = files[0].getOriginalFilename();
                if (StringUtils.isNotBlank(fileName)) {
                    //文件上传的最终路径
                    String finalPath = fileSpace + uploadPathDB + "/" + fileName;
                    //判断文件夹是否存在
                    File outFile = new File(finalPath);
                    if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                        //创建文件夹
                        outFile.getParentFile().mkdirs();
                    }
                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = files[0].getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }
            } else {
                System.out.println("file error");
                return "-1";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
        return fileName;
    }

    //根据 code 获取用户 openid 与 session_key
    private WxResult getWX(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> param = new HashMap<>();
        param.put("appid", resourceConfig.getAppId());
        param.put("secret", resourceConfig.getAppSecret());
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");

        WxResult wxResult = JsonUtils.jsonToPojo(HttpClientUtil.doGet(url, param), WxResult.class);
        return wxResult;
    }

    private void setUserRedis(WxResult wxResult) {
        redisOperator.set(wxResult.getOpenid(), wxResult.getSession_key(), 1000 * 60 * 30);
    }

    private String getUserRedis(WxResult wxResult) {
        return redisOperator.get(wxResult.getOpenid());
    }
}