package club.zudianlv.controller;

import club.zudianlv.pojo.Publish;
import club.zudianlv.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Publish addPublish(Publish publish) {
        int addPublish = publishService.addPublish(publish);
        if (addPublish > 0) {
            return new Publish("1");
        } else {
            return new Publish("-1");
        }
    }
}
