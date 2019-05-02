package club.zudianlv.pojo.vo;

/**
 * @author yinren
 * @date 2019/5/2
 */
public class UserAppend {

    private String openId;
    private String college;
    private String grade;
    private String area;
    private Integer areaNum;
    private String weixin;

    public UserAppend() {
    }

    public UserAppend(String openId, String college, String grade, String area, Integer areaNum, String weixin) {
        this.openId = openId;
        this.college = college;
        this.grade = grade;
        this.area = area;
        this.areaNum = areaNum;
        this.weixin = weixin;
    }

    @Override
    public String toString() {
        return "UserAppend{" +
                "openId='" + openId + '\'' +
                ", college='" + college + '\'' +
                ", grade='" + grade + '\'' +
                ", area='" + area + '\'' +
                ", areaNum=" + areaNum +
                ", weixin='" + weixin + '\'' +
                '}';
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }
}
