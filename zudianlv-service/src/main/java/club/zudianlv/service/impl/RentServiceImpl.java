package club.zudianlv.service.impl;

import club.zudianlv.mapper.RentMapper;
import club.zudianlv.pojo.Rent;
import club.zudianlv.pojo.vo.SelectVO;
import club.zudianlv.service.RentService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.List;

/**
 * @author yinren
 * @date 2019/5/18
 */
@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentMapper rentMapper;
    @Autowired
    private Sid sid;

    @Override
    public int addRent(Rent rent) {
        int result = rentMapper.addRent(rent);
        return result;
    }

    @Override
    public void uploadCar(String openId, String uploadDB) {
        Rent rent = rentMapper.selectOne(new Rent(openId));//查询
        if (rent != null) {//不为空，则修改
            Example example = new Example(Rent.class);
            Criteria criteria = example.createCriteria();
            criteria.andEqualTo("openId", openId);
            rent.setCarImage(uploadDB);//修改图像信息
            rentMapper.updateByExampleSelective(rent, example);
        } else {//为空，则添加
            rentMapper.insert(new Rent(sid.nextShort(), openId, uploadDB));
        }
    }

    @Override
    public Rent getRentByOpenId(String openId) {
        return rentMapper.selectOne(new Rent(openId));
    }

    @Override
    public List<Rent> getAllRent() {
        List<Rent> rentList = rentMapper.selectAllByrent(1);
        return rentList;
    }

    @Override
    public List<Rent> getRentBySelect(SelectVO selectVO) {
        List<Rent> rentBySelect = rentMapper.getRentBySelect(selectVO);
        return rentBySelect;
    }

    @Override
    public Rent getRentById(String rentId) {
        Rent rent = rentMapper.getRentById(rentId);
        return rent;
    }

    @Override
    public int changeCount(String rentId, Integer count) {
        int changeCount = rentMapper.changeCount(rentId, count);
        if (changeCount > 0){
            return count;
        }else {
            return -1;
        }
    }

    @Override
    public int rentChange(String rentId, Integer rent) {
        int rentChange = rentMapper.rentChange(rentId, rent);
        return rentChange;
    }
}
