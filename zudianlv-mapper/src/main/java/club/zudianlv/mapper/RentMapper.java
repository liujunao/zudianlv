package club.zudianlv.mapper;

import club.zudianlv.pojo.Rent;
import club.zudianlv.pojo.vo.SelectVO;
import club.zudianlv.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentMapper extends MyMapper<Rent> {
    //添加用户租车信息
    public int addRent(Rent rent);

    //根据指定条件查询
    public List<Rent> getRentBySelect(SelectVO selectVO);

    //根据 rentId 查询
    public Rent getRentById(String rentId);

    //count
    public int changeCount(@Param("rentId") String rentId, @Param("count") Integer count);

    //修改 rent 状态
    public int rentChange(@Param("rentId") String rentId, @Param("rent") Integer rent);

    //获取所有未过期出租信息
    public List<Rent> selectAllByrent(int rent);

}