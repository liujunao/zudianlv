package club.zudianlv.pojo.vo;

import club.zudianlv.pojo.Rent;
import club.zudianlv.pojo.RentTime;

import java.util.List;

/**
 * @author yinren
 * @date 2019/5/23
 */
public class RentF extends RentVO {
    private Integer favorite;

    public RentF() {
    }

    public RentF(Rent rent, List<RentTime> rentTime, Integer favorite) {
        super(rent, rentTime);
        this.favorite = favorite;
    }

    public Integer getFavorite() {
        return favorite;
    }

    public void setFavorite(Integer favorite) {
        this.favorite = favorite;
    }
}
