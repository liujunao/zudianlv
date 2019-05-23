package club.zudianlv.pojo.vo;

import club.zudianlv.pojo.Publish;

/**
 * @author yinren
 * @date 2019/5/23
 */
public class PublishF {
    private Integer favorite;
    private Publish publish;

    public PublishF() {
    }

    public PublishF(Integer favorite, Publish publish) {
        this.favorite = favorite;
        this.publish = publish;
    }

    public Publish getPublish() {
        return publish;
    }

    public void setPublish(Publish publish) {
        this.publish = publish;
    }

    public Integer getFavorite() {
        return favorite;
    }

    public void setFavorite(Integer favorite) {
        this.favorite = favorite;
    }
}
