package club.zudianlv.controller;

import club.zudianlv.pojo.Rent;
import club.zudianlv.pojo.vo.SelectVO;
import club.zudianlv.service.RentService;
import club.zudianlv.service.impl.RentServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author yinren
 * @date 2019/5/18
 */
public class UserControllerTest {
    private RentService rentService = new RentServiceImpl();

    @Test
    public void test() {
        int a = 1;
        System.out.println(testAdd(a));
    }

    private int testAdd(int a) {
        return a + 1;
    }


    @Test
    public void selectTest() {
        SelectVO selectVO = new SelectVO("韵苑", null, new Integer[]{}, 1, 1);
        List<Rent> rentBySelect = rentService.getRentBySelect(selectVO);
        for (Rent rent : rentBySelect) {
            System.out.println(rent);
        }
    }

}