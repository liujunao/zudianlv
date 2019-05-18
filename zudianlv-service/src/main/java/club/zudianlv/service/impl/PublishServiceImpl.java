package club.zudianlv.service.impl;

import club.zudianlv.mapper.PublishMapper;
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

    @Override
    public List<Publish> publishListByOpenId(String openId) {
        List<Publish> publishList = publishMapper.select(new Publish(openId));
        return publishList;
    }

    @Override
    public void deleteById(String publishId, String openId) {
        publishMapper.delete(new Publish(publishId,openId));
    }

    @Override
    public List<Publish> allPublish() {
        return publishMapper.selectAll();
    }

    @Override
    public int addPublish(Publish publish) {
        publish.setPublishId(sid.nextShort());
        int insert = publishMapper.insert(publish);
        return insert;
    }
}
