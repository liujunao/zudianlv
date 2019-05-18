package club.zudianlv.pojo.vo;

import club.zudianlv.pojo.Rent;
import club.zudianlv.pojo.RentTime;

import java.util.List;

/**
 * @author yinren
 * @date 2019/5/18
 */
public class RentVO {

    private Rent rent;
    private List<RentTime> rentTime;

    public RentVO() {
    }

    public RentVO(Rent rent) {
        this.rent = rent;
    }

    public RentVO(Rent rent, List<RentTime> rentTime) {
        this.rent = rent;
        this.rentTime = rentTime;
    }

    @Override
    public String toString() {
        return "RentVO{" +
                "rent=" + rent +
                ", rentTime=" + rentTime +
                '}';
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public List<RentTime> getRentTime() {
        return rentTime;
    }

    public void setRentTime(List<RentTime> rentTime) {
        this.rentTime = rentTime;
    }
}
