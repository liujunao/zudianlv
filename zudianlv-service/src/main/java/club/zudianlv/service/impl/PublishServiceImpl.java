package club.zudianlv.service.impl;

import club.zudianlv.mapper.FavoriteMapper;
import club.zudianlv.mapper.PublishMapper;
import club.zudianlv.pojo.Favorite;
import club.zudianlv.pojo.Publish;
import club.zudianlv.service.PublishService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yinren
 * @date 2019/5/18
 */
@Service
public class PublishServiceImpl implements PublishService {
    @Autowired
    private PublishMapper publishMapper;
    @Autowired
    private Sid sid;
    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public List<Publish> publishListByOpenId(String openId) {
        List<Publish> publishList = publishMapper.publishListByOpenId(openId);
        return publishList;
    }

    @Override
    public void deleteById(String publishId, String openId) {
        publishMapper.delete(new Publish(publishId, openId));
        //检测是否存在收藏关联
        Favorite favorite = favoriteMapper.selectOne(new Favorite(openId, publishId, 2));
        if (favorite != null){
            favoriteMapper.deleteFavorite(favorite);
        }
    }

    @Override
    public List<Publish> allPublish() {
        return publishMapper.selectAllByOK(0);
    }

    @Override
    public Publish addPublish(Publish publish) {
        String id = sid.nextShort();
        publish.setPublishId(id);
        int insert = publishMapper.insert(publish);
        if (insert > 0) {
            return getPublishById(id);
        } else {
            return new Publish("-1");
        }
    }

    @Override
    public Publish getPublishById(String publishId) {
        Publish publish = publishMapper.selectOne(new Publish(publishId, 2));
        return publish;
    }

    @Override
    public int changeCount(String publishId, Integer count) {
        int changeCount = publishMapper.changeCount(publishId, count);
        if (changeCount > 0){
            return count;
        }else {
            return -1;
        }
    }

    @Override
    public int statusChange(String publishId, Integer status) {
        int change = publishMapper.statusChange(publishId, status);
        return change;
    }
}
