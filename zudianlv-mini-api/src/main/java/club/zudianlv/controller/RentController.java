package club.zudianlv.controller;

import club.zudianlv.pojo.Rent;
import club.zudianlv.pojo.RentTime;
import club.zudianlv.pojo.vo.RentVO;
import club.zudianlv.pojo.vo.SelectVO;
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

    //页面自动加载空闲车信息
    @RequestMapping("/list")
    public List<RentVO> rentList() {
        List<RentVO> rentVOList = new ArrayList<>();

        List<Rent> allRent = rentService.getAllRent();
        for (Rent rent : allRent) {
            List<RentTime> rentTimes = rentTimeService.getRentTimeByOpenId(rent.getOpenId());
            rentVOList.add(new RentVO(rent, rentTimes));
        }
        return rentVOList;
    }

    //车辆筛选
    @RequestMapping("/select")
    public List<RentVO> rentSelect(@RequestBody SelectVO selectVO) {
        List<RentVO> rentVOList = new ArrayList<>();//存放结果

        List<Rent> rentBySelect = rentService.getRentBySelect(selectVO);//查询
        Integer[] week = selectVO.getWeek();
        //筛选
        for (Rent rent : rentBySelect) {
            int[] ints = strToInt(rent.getRentTimeId().split(","));
            boolean checkSame = checkSame(week, ints);
            if (checkSame) {
                List<RentTime> rentTimeByOpenId = rentTimeService.getRentTimeByOpenId(rent.getOpenId());
                rentVOList.add(new RentVO(rent, rentTimeByOpenId));
            }
        }
        return rentVOList;
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
