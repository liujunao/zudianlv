package club.zudianlv.mapper;

import club.zudianlv.pojo.Publish;
import club.zudianlv.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublishMapper extends MyMapper<Publish> {
    //count
    public int changeCount(@Param("publishId") String publishId, @Param("count") Integer count);

    //求租信息修改
    public int statusChange(@Param("publishId") String publishId, @Param("status") Integer status);

    //获取未过期且有效的求租信息
    public List<Publish> selectAllByOK(int status);

    //获取指定 openId 信息
    public List<Publish> publishListByOpenId(String openId);
}