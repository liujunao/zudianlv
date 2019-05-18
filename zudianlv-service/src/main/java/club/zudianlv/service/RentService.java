package club.zudianlv.service;

import club.zudianlv.pojo.Rent;
import club.zudianlv.pojo.vo.SelectVO;

import java.util.List;

/**
 * @author yinren
 * @date 2019/5/18
 */
public interface RentService {

    //添加出租信息
    public int addRent(Rent rent);

    //上传出租车辆图片
    public void uploadCar(String openId, String uploadDB);

    //根据 openId 返回出租信息
    public Rent getRentByOpenId(String openId);

    //返回所有租车信息
    public List<Rent> getAllRent();

    //根据指定条件查询
    public List<Rent> getRentBySelect(SelectVO selectVO);
}
