package club.zudianlv.controller;

import club.zudianlv.pojo.Publish;
import club.zudianlv.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yinren
 * @date 2019/5/18
 */
@RestController
@RequestMapping("/publish")
public class PublishController {
    @Autowired
    private PublishService publishService;

    //获取所有求租信息列表
    @RequestMapping("/list")
    public List<Publish> publishList() {
        return publishService.allPublish();
    }

    //发布求租信息
    @RequestMapping("/add")
    public Publish addPublish(@RequestBody Publish publish) {
        System.out.println(publish);
        Publish addPublish = publishService.addPublish(publish);
        return addPublish;
    }
}
