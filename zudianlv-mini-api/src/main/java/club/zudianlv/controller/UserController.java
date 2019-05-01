package club.zudianlv.controller;

import club.zudianlv.pojo.vo.UserVO;
import club.zudianlv.utils.JSONResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinren
 * @date 2019/5/1
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/wxLogin")
    public JSONResult wxLogin(@RequestBody UserVO userVO) {
        System.out.println(userVO);
        return JSONResult.ok();
    }
}
