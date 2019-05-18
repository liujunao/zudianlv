package club.zudianlv.service.impl;

import club.zudianlv.mapper.RentTimeMapper;
import club.zudianlv.pojo.RentTime;
import club.zudianlv.service.RentTimeService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yinren
 * @date 2019/5/18
 */
@Service
public class RentTimeServiceImpl implements RentTimeService {

    @Autowired
    private RentTimeMapper rentTimeMapper;
    @Autowired
    private Sid sid;

    @Override
    public void addRentTime(List<RentTime> rentTimes,String openId) {
        for (RentTime rentTime: rentTimes){
            rentTime.setRentTimeId(sid.nextShort());
            rentTime.setOpenId(openId);
            rentTimeMapper.insert(rentTime);
        }
    }

    @Override
    public List<RentTime> getRentTimeByOpenId(String openId) {
        List<RentTime> select = rentTimeMapper.select(new RentTime(openId));
        return select;
    }

    @Override
    public void deleteByOpenId(String openId) {
        rentTimeMapper.delete(new RentTime(openId));
    }
}
