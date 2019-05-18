package club.zudianlv.service;

import club.zudianlv.pojo.RentTime;

import java.util.List;

/**
 * @author yinren
 * @date 2019/5/18
 */
public interface RentTimeService {

    //添加可出租时间段
    public void addRentTime(List<RentTime> rentTimes, String openId);
    //获取指定 openId 的字段
    public List<RentTime> getRentTimeByOpenId(String openId);
    //删除指定 openId 的值
    public void deleteByOpenId(String openId);
}
