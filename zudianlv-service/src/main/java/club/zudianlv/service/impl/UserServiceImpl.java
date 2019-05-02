package club.zudianlv.service.impl;

import club.zudianlv.mapper.UserMapper;
import club.zudianlv.pojo.User;
import club.zudianlv.pojo.vo.UserAppend;
import club.zudianlv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @author yinren
 * @date 2019/5/2
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveRegister(User user) {
        userMapper.insert(user);
    }

    @Override
    public String getIdAndSession(String openId) {
        String sessionById = userMapper.selectSessionById(openId);
        return sessionById;
    }

    @Override
    public void updateWxUser(User user) {
        userMapper.updateWxUser(user);
    }

    @Override
    public User getUser(String openId) {
        User user = userMapper.selectOne(new User(openId));
        return user;
    }

    @Override
    public int appendUser(UserAppend userAppend) {
        User user = new User(userAppend.getOpenId(), userAppend.getCollege(), userAppend.getGrade(), userAppend.getArea(), userAppend.getAreaNum(), userAppend.getWeixin());
        int append = userMapper.updateUserAppend(user);
        return append;
    }

    @Override
    public void uploadHust(User user) {
        Example example = new Example(User.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("openId", user.getOpenId());
        userMapper.updateByExampleSelective(user, example);
    }
}
