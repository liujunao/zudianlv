package club.zudianlv.service;

import club.zudianlv.pojo.Used;

import java.util.List;

/**
 * @author yinren
 * @date 2019/5/18
 */
public interface UsedService {

    //根据 openId 获取指定二手车信息
    public Used getUsedByOpenId(String openId);
    //更新 used 信息
    public int updateUsed(Used used);
    //添加二手车信息
    public void addUsed(Used used);
    //获取所有二手车信息
    public List<Used> getAllUsed();
}
