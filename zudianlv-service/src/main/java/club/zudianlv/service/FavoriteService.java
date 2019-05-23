package club.zudianlv.service;

import club.zudianlv.pojo.Favorite;

import java.util.List;

/**
 * @author yinren
 * @date 2019/5/23
 */
public interface FavoriteService {

    //根据 openId 获取指定用户信息
    public List<Favorite> getFavoriteListByOpenId(String openId);

    //根据 openId 与 otherId 查询
    public Favorite getFavoriteByopenIdAndOtherId(String openId, String otherId, Integer type);

    //更新收藏状态
    public int changeFavorite(Favorite favorite);
}
