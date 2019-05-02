package club.zudianlv.mapper;

import club.zudianlv.pojo.User;
import club.zudianlv.utils.MyMapper;
import org.apache.commons.lang3.StringUtils;

public interface UserMapper extends MyMapper<User> {

    //根据 openId 获取 session_key
    public String selectSessionById(String openId);

    //用户信息改变时，进行及时更新
    public void updateWxUser(User user);

    //完善用户信息
    public int updateUserAppend(User user);

}