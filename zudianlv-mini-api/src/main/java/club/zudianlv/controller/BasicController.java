package club.zudianlv.controller;

import club.zudianlv.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yinren
 * @date 2019/5/2
 */
public class BasicController {
    @Autowired
    public RedisOperator redisOperator;

    //每页分页记录数
    public static final Integer PAGE_SIZE = 5;
}
