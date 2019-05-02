package club.zudianlv.pojo;

import javax.persistence.*;

@Table(name = "rent_time")
public class RentTime {
    /**
     * 空闲时间段id
     */
    @Id
    @Column(name = "rent_time_id")
    private String rentTimeId;

    /**
     * 周几：1--> 周一
     */
    private Integer week;

    /**
     * 求租的开始时间 hh:mm
     */
    @Column(name = "begin_time")
    private String beginTime;

    /**
     * 求租的结束时间 hh:mm
     */
    @Column(name = "end_time")
    private String endTime;

    /**
     * 获取空闲时间段id
     *
     * @return rent_time_id - 空闲时间段id
     */
    public String getRentTimeId() {
        return rentTimeId;
    }

    /**
     * 设置空闲时间段id
     *
     * @param rentTimeId 空闲时间段id
     */
    public void setRentTimeId(String rentTimeId) {
        this.rentTimeId = rentTimeId;
    }

    /**
     * 获取周几：1--> 周一
     *
     * @return week - 周几：1--> 周一
     */
    public Integer getWeek() {
        return week;
    }

    /**
     * 设置周几：1--> 周一
     *
     * @param week 周几：1--> 周一
     */
    public void setWeek(Integer week) {
        this.week = week;
    }

    /**
     * 获取求租的开始时间 hh:mm
     *
     * @return begin_time - 求租的开始时间 hh:mm
     */
    public String getBeginTime() {
        return beginTime;
    }

    /**
     * 设置求租的开始时间 hh:mm
     *
     * @param beginTime 求租的开始时间 hh:mm
     */
    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 获取求租的结束时间 hh:mm
     *
     * @return end_time - 求租的结束时间 hh:mm
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置求租的结束时间 hh:mm
     *
     * @param endTime 求租的结束时间 hh:mm
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}