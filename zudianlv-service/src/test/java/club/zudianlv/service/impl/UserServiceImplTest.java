package club.zudianlv.service.impl;

import club.zudianlv.service.UserService;
import org.junit.Test;

/**
 * @author yinren
 * @date 2019/5/2
 */
public class UserServiceImplTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void saveRegister() throws Exception {
    }

    @Test
    public void getIdAndSession() throws Exception {
        System.out.println(userService.getIdAndSession("o0XSa5YQSaOKlpexvm47kBhBV6Bo") == null ? true : false);
    }

}