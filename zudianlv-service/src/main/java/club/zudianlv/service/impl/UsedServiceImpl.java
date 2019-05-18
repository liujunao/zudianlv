package club.zudianlv.service.impl;

import club.zudianlv.mapper.UsedMapper;
import club.zudianlv.pojo.Used;
import club.zudianlv.pojo.User;
import club.zudianlv.service.UsedService;
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
        return usedMapper.selectAll();
    }
}
