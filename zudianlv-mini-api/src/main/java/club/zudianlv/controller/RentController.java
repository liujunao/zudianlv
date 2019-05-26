package club.zudianlv.controller;

import club.zudianlv.pojo.Favorite;
import club.zudianlv.pojo.Rent;
import club.zudianlv.pojo.RentTime;
import club.zudianlv.pojo.vo.RentF;
import club.zudianlv.pojo.vo.SelectVO;
import club.zudianlv.service.FavoriteService;
import club.zudianlv.service.RentService;
import club.zudianlv.service.RentTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yinren
 * @date 2019/5/16
 */
@RestController
@RequestMapping("/rent")
public class RentController {
    @Autowired
    private RentService rentService;
    @Autowired
    private RentTimeService rentTimeService;
    @Autowired
    private FavoriteService favoriteService;

    //页面自动加载空闲车信息
    @RequestMapping("/list")
    public List<RentF> rentList() {
        List<RentF> rentFList = new ArrayList<>();

        List<Rent> allRent = rentService.getAllRent();
        for (Rent rent : allRent) {
            List<RentTime> rentTimes = rentTimeService.getRentTimeByOpenId(rent.getOpenId());
            rentFList = getFavoriteById(rent, rentFList, rentTimes);//将 favorite 加入
        }
        return rentFList;
    }

    //车辆筛选
    @RequestMapping("/select")
    public List<RentF> rentSelect(@RequestBody SelectVO selectVO) {
        List<RentF> rentFList = new ArrayList<>();//存放结果

        List<Rent> rentBySelect = rentService.getRentBySelect(selectVO);//查询
        Integer[] week = selectVO.getWeek();
        //筛选
        for (Rent rent : rentBySelect) {
            if (week.length != 0) { //根据星期筛选
                int[] ints = strToInt(rent.getRentTimeId().split(","));
                boolean checkSame = checkSame(week, ints);
                if (checkSame) {
                    List<RentTime> rentTimes = rentTimeService.getRentTimeByOpenId(rent.getOpenId());
                    rentFList = getFavoriteById(rent, rentFList, rentTimes);//将 favorite 加入
                }
            } else {
                List<RentTime> rentTimes = rentTimeService.getRentTimeByOpenId(rent.getOpenId());
                rentFList = getFavoriteById(rent, rentFList, rentTimes);//将 favorite 加入
            }
        }
        return rentFList;
    }

    //添加阅读数
    @RequestMapping("/count")
    public Integer count(String rentId, Integer count) {
        if (rentId == null || count == null) {
            return -1;
        } else {
            int changeCount = rentService.changeCount(rentId, count);
            return changeCount;
        }
    }

    //根据 openId 与 otherId 获取信息
    private List<RentF> getFavoriteById(Rent rent, List<RentF> rentFList, List<RentTime> rentTimes) {
        Favorite favorite = favoriteService.getFavoriteByopenIdAndOtherId(rent.getOpenId(), rent.getRentId(), 1);
        if (favorite != null) {
            rentFList.add(new RentF(rent, rentTimes, favorite.getType()));
        } else {
            rentFList.add(new RentF(rent, rentTimes, 0));
        }
        return rentFList;
    }

    //将 String 数组转换为 int 数组
    public int[] strToInt(String[] strings) {
        int[] intTmp = new int[strings.length];
        int index = 0;
        for (String str : strings) {
            intTmp[index] = Integer.parseInt(str);
            index++;
        }
        return intTmp;
    }

    //判断两个 int 数组是否存在相同值
    public boolean checkSame(Integer[] arr1, int[] arr2) {
        //排序
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int index1 = 0, index2 = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] == arr2[index2]) {
                return true;
            } else if (arr1[index1] > arr2[index2]) {
                index2++;
            } else {
                index1++;
            }
        }
        return false;
    }
}
