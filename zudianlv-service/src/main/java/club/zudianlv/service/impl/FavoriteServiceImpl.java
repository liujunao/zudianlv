package club.zudianlv.service.impl;

import club.zudianlv.mapper.FavoriteMapper;
import club.zudianlv.pojo.Favorite;
import club.zudianlv.service.FavoriteService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yinren
 * @date 2019/5/23
 */
@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteMapper favoriteMapper;
    @Autowired
    private Sid sid;

    @Override
    public List<Favorite> getFavoriteListByOpenId(String openId) {
        List<Favorite> select = favoriteMapper.select(new Favorite(openId));
        return select;
    }

    @Override
    public Favorite getFavoriteByopenIdAndOtherId(String openId, String otherId, Integer type) {
        Favorite favorite = favoriteMapper.selectOne(new Favorite(openId, otherId, type));
        return favorite;
    }

    @Override
    public int changeFavorite(Favorite favorite) {
        if (favorite.getType() == 0) {
            return favoriteMapper.deleteFavorite(favorite);
        } else {
            favorite.setFavoriteId(sid.nextShort());
            int insert = favoriteMapper.insert(favorite);
            return insert;
        }
    }
}
