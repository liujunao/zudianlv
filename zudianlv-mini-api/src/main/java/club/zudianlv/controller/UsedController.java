package club.zudianlv.controller;

import club.zudianlv.pojo.Used;
import club.zudianlv.service.UsedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yinren
 * @date 2019/5/18
 */
@RestController
@RequestMapping("/used")
public class UsedController {
    @Autowired
    private UsedService usedService;

    @RequestMapping("/list")
    public List<Used> usedList() {
        return usedService.getAllUsed();
    }
}
