package club.zudianlv.pojo;

import javax.persistence.Column;

/**
 * @author yinren
 * @date 2019/5/23
 */
public class Favorite {

    @Column(name = "favorite_id")
    private String favoriteId;
    @Column(name = "open_id")
    private String openId;
    @Column(name = "other_id")
    private String otherId;
    //收藏帖子的类别：0：rent  1：publish  2：used
    private Integer type;

    public Favorite() {
    }

    public Favorite(String openId, String otherId, Integer type) {
        this.openId = openId;
        this.otherId = otherId;
        this.type = type;
    }

    public Favorite(String openId) {
        this.openId = openId;
    }

    public String getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(String favoriteId) {
        this.favoriteId = favoriteId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOtherId() {
        return otherId;
    }

    public void setOtherId(String otherId) {
        this.otherId = otherId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
