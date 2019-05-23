package club.zudianlv.pojo.vo;

import club.zudianlv.pojo.Used;

/**
 * @author yinren
 * @date 2019/5/23
 */
public class UsedF {
    private Used used;
    private Integer favorite;

    public UsedF() {
    }

    public UsedF(Used used, Integer favorite) {
        this.used = used;
        this.favorite = favorite;
    }

    public Used getUsed() {
        return used;
    }

    public void setUsed(Used used) {
        this.used = used;
    }

    public Integer getFavorite() {
        return favorite;
    }

    public void setFavorite(Integer favorite) {
        this.favorite = favorite;
    }
}
