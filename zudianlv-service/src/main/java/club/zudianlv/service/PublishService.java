package club.zudianlv.service;

import club.zudianlv.pojo.Publish;

import java.util.List;

/**
 * @author yinren
 * @date 2019/5/18
 */
public interface PublishService {

    //获取指定求租信息列表
    public List<Publish> publishListByOpenId(String openId);

    //删除指定求租信息
    public void deleteById(String publishId, String openId);

    //获取所有求租信息列表
    public List<Publish> allPublish();

    //添加 publish
    public Publish addPublish(Publish publish);

    //根据 publishId 返回
    public Publish getPublishById(String publishId);

    //count
    public int changeCount(String publishId, Integer count);

    //求租信息修改
    public int statusChange(String publishId, Integer status);
}
