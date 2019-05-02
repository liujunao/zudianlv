package club.zudianlv.controller;

import club.zudianlv.config.ResourceConfig;
import club.zudianlv.pojo.User;
import club.zudianlv.pojo.vo.UserAppend;
import club.zudianlv.pojo.vo.UserVO;
import club.zudianlv.pojo.vo.WxResult;
import club.zudianlv.service.UserService;
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
import java.util.HashMap;
import java.util.Map;

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
//        userService.saveRegister(user);//将用户信息保存到数据库
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
        System.out.println("code: " + code);
        WxResult wx = getWX(code);
        String redisSessionKey = redisOperator.get(wx.getOpenid());
        if (redisSessionKey != null) {
            return new User(wx.getOpenid()); //用户信息未改变且在redis中保存
        } else {//redis 中未保存或过期
            String session = userService.getIdAndSession(wx.getOpenid());//从数据库中获取 session_key
            if (session.equals(wx.getSession_key())) {//session_key 相同
                setUserRedis(wx);//再次保存到 redis 中
                return new User(wx.getOpenid());
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
            System.out.println(userAppend);
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
        //文件保存位置
        String fileSpace = resourceConfig.getFileSpace();
        //保存到数据库中的相对路径
        String uploadPathDB = "/" + openId;

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try {
            if (files != null && files.length > 0) {
                String fileName = files[0].getOriginalFilename();
                if (StringUtils.isNotBlank(fileName)) {
                    //文件上传的最终路径
                    String finalPath = fileSpace + uploadPathDB + "/" + fileName;
                    uploadPathDB += "/" + fileName;
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
                return new User("-1");
            }
        } catch (Exception e) {
            return new User("-1");
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
        User uploadUser = new User(openId, uploadPathDB);
        userService.uploadHust(uploadUser);

        return userService.getUser(openId);
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