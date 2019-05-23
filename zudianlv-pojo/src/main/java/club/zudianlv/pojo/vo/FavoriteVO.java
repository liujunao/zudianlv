package club.zudianlv.pojo.vo;

import club.zudianlv.pojo.Publish;
import club.zudianlv.pojo.Used;

import java.util.List;

/**
 * @author yinren
 * @date 2019/5/23
 */
public class FavoriteVO {
    private List<RentVO> rent;
    private List<Publish> publish;
    private List<Used> used;

    public FavoriteVO() {
    }

    public FavoriteVO(List<RentVO> rent, List<Publish> publish, List<Used> used) {
        this.rent = rent;
        this.publish = publish;
        this.used = used;
    }

    @Override
    public String toString() {
        return "FavoriteVO{" +
                "rent=" + rent +
                ", publish=" + publish +
                ", used=" + used +
                '}';
    }

    public List<RentVO> getRent() {
        return rent;
    }

    public void setRent(List<RentVO> rent) {
        this.rent = rent;
    }

    public List<Publish> getPublish() {
        return publish;
    }

    public void setPublish(List<Publish> publish) {
        this.publish = publish;
    }

    public List<Used> getUsed() {
        return used;
    }

    public void setUsed(List<Used> used) {
        this.used = used;
    }
}
