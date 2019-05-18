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
    public void deleteById(String publishId,String openId);
    //获取所有求租信息列表
    public List<Publish> allPublish();
    //添加 publish
    public int addPublish(Publish publish);
}
