package club.zudianlv.service.impl;

import club.zudianlv.mapper.UsedMapper;
import club.zudianlv.pojo.Used;
import club.zudianlv.pojo.User;
import club.zudianlv.service.UsedService;
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
public class UsedServiceImpl implements UsedService {
    @Autowired
    private UsedMapper usedMapper;
    @Autowired
    private Sid sid;

    @Override
    public Used getUsedByOpenId(String openId) {
        Used used = usedMapper.selectOne(new Used(openId));
        return used;
    }

    @Override
    public int updateUsed(Used used) {
        Example example = new Example(User.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("openId", used.getOpenId());
        int update = usedMapper.updateByExampleSelective(used, example);
        return update;
    }

    @Override
    public void addUsed(Used used) {
        usedMapper.insert(used);
    }

    @Override
    public List<Used> getAllUsed() {
        return usedMapper.selectAllByUsed(1);
    }

    @Override
    public Used getUsedById(String usedId) {
        Used usedById = usedMapper.getUsedById(usedId);
        return usedById;
    }

    @Override
    public int changeCount(String usedId, Integer count) {
        int changeCount = usedMapper.changeCount(usedId, count);
        return changeCount;
    }

    @Override
    public int usedChange(String usedId, Integer used) {
        int usedChange = usedMapper.usedChange(usedId, used);
        return usedChange;
    }

    @Override
    public void uploadCar(String openId, String uploadDB) {
        Used used = usedMapper.selectOne(new Used(openId));//查询
        if (used != null) {//不为空，则修改
            Example example = new Example(Used.class);
            Criteria criteria = example.createCriteria();
            criteria.andEqualTo("openId", openId);
            used.setUsedImage(uploadDB);//修改图像信息
            usedMapper.updateByExampleSelective(used, example);
        } else {//为空，则添加
            usedMapper.insert(new Used(sid.nextShort(), openId, uploadDB));
        }
    }
}
