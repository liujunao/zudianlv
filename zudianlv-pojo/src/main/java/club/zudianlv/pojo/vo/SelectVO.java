package club.zudianlv.pojo.vo;

/**
 * @author yinren
 * @date 2019/5/18
 */
public class SelectVO {
    private String area; //宿舍区
    private Integer areaNum;//楼栋
    private Integer[] week;//周几
    private Integer manned;//0:可载人 1：不可 2：不限
    private Integer gender;//0:女 1：男

    public SelectVO() {
    }

    public SelectVO(String area, Integer areaNum, Integer[] week, Integer manned, Integer gender) {
        this.area = area;
        this.areaNum = areaNum;
        this.week = week;
        this.manned = manned;
        this.gender = gender;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getAreaNum() {
        return areaNum;
    }

    public void setAreaNum(Integer areaNum) {
        this.areaNum = areaNum;
    }

    public Integer[] getWeek() {
        return week;
    }

    public void setWeek(Integer[] week) {
        this.week = week;
    }

    public Integer getManned() {
        return manned;
    }

    public void setManned(Integer manned) {
        this.manned = manned;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
