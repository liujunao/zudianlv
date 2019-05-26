package club.zudianlv.mapper;

import club.zudianlv.pojo.Used;
import club.zudianlv.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsedMapper extends MyMapper<Used> {

    //根据 id 查询
    public Used getUsedById(String usedId);

    //count
    public int changeCount(@Param("usedId") String usedId, @Param("count") Integer count);

    //二手车状态修改
    public int usedChange(@Param("usedId") String usedId, @Param("used") Integer used);

    //获取所有未过期二手车信息
    public List<Used> selectAllByUsed(int used);
}