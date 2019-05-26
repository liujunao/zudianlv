package club.zudianlv.controller;

import club.zudianlv.pojo.Favorite;
import club.zudianlv.pojo.Publish;
import club.zudianlv.pojo.vo.PublishF;
import club.zudianlv.service.FavoriteService;
import club.zudianlv.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private FavoriteService favoriteService;

    //获取所有求租信息列表
    @RequestMapping("/list")
    public List<PublishF> publishList() {
        List<PublishF> publishFList = new ArrayList<>();

        List<Publish> publishList = publishService.allPublish();
        for (Publish publish : publishList) {
            Favorite favorite = favoriteService.getFavoriteByopenIdAndOtherId(publish.getOpenId(), publish.getPublishId(), 2);
            if (favorite != null) {
                publishFList.add(new PublishF(2, publish));
            } else {
                publishFList.add(new PublishF(0, publish));
            }
        }
        return publishFList;
    }

    //发布求租信息
    @RequestMapping("/add")
    public Publish addPublish(@RequestBody Publish publish) {
        publish.setCreateTime(Long.toString(new Date().getTime()));
        Publish addPublish = publishService.addPublish(publish);
        return addPublish;
    }

    //添加阅读数
    @RequestMapping("/count")
    public Integer count(String publishId, Integer count) {
        if (publishId == null || count == null) {
            return -1;
        } else {
            int changeCount = publishService.changeCount(publishId, count);
            return changeCount;
        }
    }

    //出租状态修改
    @RequestMapping("/status")
    public Integer usedChange(String publishId, Integer status) {
        if (publishId == null || status == null) {
            return -1;
        } else {
            int change = publishService.statusChange(publishId, status);
            if (change > 0) {
                return status;
            } else {
                return -1;
            }
        }
    }
}
