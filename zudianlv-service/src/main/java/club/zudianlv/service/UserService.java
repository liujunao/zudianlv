package club.zudianlv.service;

import club.zudianlv.pojo.User;
import club.zudianlv.pojo.vo.UserAppend;

/**
 * @author yinren
 * @date 2019/5/2
 */
public interface UserService {

    //保存用户注册时的信息
    public void saveRegister(User user);
    //查询用户 openid 与 session_key
    public String getIdAndSession(String openId);
    //用户信息改变时，进行及时更新
    public void updateWxUser(User user);
    //获取完整的用户信息
    public User getUser(String openId);
    //完善用户信息
    public int appendUser(UserAppend userAppend);
    //上传学生证照片
    public void uploadHust(User user);
}
