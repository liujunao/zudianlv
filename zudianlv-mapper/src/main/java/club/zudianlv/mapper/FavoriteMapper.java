package club.zudianlv.mapper;

import club.zudianlv.pojo.Favorite;
import club.zudianlv.utils.MyMapper;

public interface FavoriteMapper extends MyMapper<Favorite> {
    //删除收藏信息
    public int deleteFavorite(Favorite favorite);
}