package club.zudianlv.controller;

import club.zudianlv.pojo.Favorite;
import club.zudianlv.pojo.Used;
import club.zudianlv.pojo.vo.UsedF;
import club.zudianlv.service.FavoriteService;
import club.zudianlv.service.UsedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping("/list")
    public List<UsedF> usedList() {
        List<UsedF> usedFList = new ArrayList<>();

        List<Used> useds = usedService.getAllUsed();
        for (Used used : useds) {
            Favorite favorite = favoriteService.getFavoriteByopenIdAndOtherId(used.getOpenId(), used.getUsedId(), 3);
            if (favorite != null){
                usedFList.add(new UsedF(used,3));
            }else {
                usedFList.add(new UsedF(used,0));
            }
        }
        return usedFList;
    }

    //添加阅读数
    @RequestMapping("/count")
    public Integer count(String usedId, Integer count) {
        if (usedId == null) {
            return -1;
        } else {
            int changeCount = usedService.changeCount(usedId, count);
            return changeCount;
        }
    }
}
