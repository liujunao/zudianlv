package club.zudianlv.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinren
 * @date 2019/5/19
 */
@RestController
public class HelloWorld {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world!";
    }
}
