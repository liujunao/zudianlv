package club.zudianlv.mapper;

import club.zudianlv.pojo.Used;
import club.zudianlv.utils.MyMapper;

public interface UsedMapper extends MyMapper<Used> {

    //根据 id 查询
    public Used getUsedById(String usedId);

    //count
    public int changeCount(String usedId, Integer count);

    //二手车状态修改
    public int usedChange(String usedId, Integer used);
}