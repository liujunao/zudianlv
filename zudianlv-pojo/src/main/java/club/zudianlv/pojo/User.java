package club.zudianlv.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class User {
    /**
     * 用户 ID
     */
    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 昵称
     */
    @Column(name = "nickName")
    private String nickname;

    /**
     * 性别： 0：女 1：男
     */
    private Integer gender;

    /**
     * 头像
     */
    @Column(name = "avatarUrl")
    private String avatarUrl;

    /**
     * 学生证照片
     */
    @Column(name = "hust_image")
    private String hustImage;

    /**
     * 学院
     */
    private String college;

    /**
     * 年级
     */
    private String grade;

    /**
     * 宿舍区：韵苑
     */
    private String area;

    /**
     * 楼栋：16栋（传数字）
     */
    @Column(name = "area_num")
    private Integer areaNum;

    /**
     * 微信号
     */
    private String weixin;

    /**
     * 出租信息展示 0：未发布 1：发布展示 2：发布未展示
     */
    private Integer rent;

    /**
     * 二手车信息展示 0：未发布 1：发布未出售 2：发布未出售
     */
    private Integer used;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender=" + gender +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", hustImage='" + hustImage + '\'' +
                ", college='" + college + '\'' +
                ", grade='" + grade + '\'' +
                ", area='" + area + '\'' +
                ", areaNum=" + areaNum +
                ", weixin='" + weixin + '\'' +
                ", rent=" + rent +
                ", used=" + used +
                '}';
    }

    /**
     * 获取用户 ID
     *
     * @return user_id - 用户 ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户 ID
     *
     * @param userId 用户 ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取昵称
     *
     * @return nickName - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取性别： 0：女 1：男
     *
     * @return gender - 性别： 0：女 1：男
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别： 0：女 1：男
     *
     * @param gender 性别： 0：女 1：男
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取头像
     *
     * @return avatarUrl - 头像
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * 设置头像
     *
     * @param avatarUrl 头像
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * 获取学生证照片
     *
     * @return hust_image - 学生证照片
     */
    public String getHustImage() {
        return hustImage;
    }

    /**
     * 设置学生证照片
     *
     * @param hustImage 学生证照片
     */
    public void setHustImage(String hustImage) {
        this.hustImage = hustImage;
    }

    /**
     * 获取学院
     *
     * @return college - 学院
     */
    public String getCollege() {
        return college;
    }

    /**
     * 设置学院
     *
     * @param college 学院
     */
    public void setCollege(String college) {
        this.college = college;
    }

    /**
     * 获取年级
     *
     * @return grade - 年级
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 设置年级
     *
     * @param grade 年级
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * 获取宿舍区：韵苑
     *
     * @return area - 宿舍区：韵苑
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置宿舍区：韵苑
     *
     * @param area 宿舍区：韵苑
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取楼栋：16栋（传数字）
     *
     * @return area_num - 楼栋：16栋（传数字）
     */
    public Integer getAreaNum() {
        return areaNum;
    }

    /**
     * 设置楼栋：16栋（传数字）
     *
     * @param areaNum 楼栋：16栋（传数字）
     */
    public void setAreaNum(Integer areaNum) {
        this.areaNum = areaNum;
    }

    /**
     * 获取微信号
     *
     * @return weixin - 微信号
     */
    public String getWeixin() {
        return weixin;
    }

    /**
     * 设置微信号
     *
     * @param weixin 微信号
     */
    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    /**
     * 获取出租信息展示 0：未发布 1：发布展示 2：发布未展示
     *
     * @return rent - 出租信息展示 0：未发布 1：发布展示 2：发布未展示
     */
    public Integer getRent() {
        return rent;
    }

    /**
     * 设置出租信息展示 0：未发布 1：发布展示 2：发布未展示
     *
     * @param rent 出租信息展示 0：未发布 1：发布展示 2：发布未展示
     */
    public void setRent(Integer rent) {
        this.rent = rent;
    }

    /**
     * 获取二手车信息展示 0：未发布 1：发布未出售 2：发布未出售
     *
     * @return used - 二手车信息展示 0：未发布 1：发布未出售 2：发布未出售
     */
    public Integer getUsed() {
        return used;
    }

    /**
     * 设置二手车信息展示 0：未发布 1：发布未出售 2：发布未出售
     *
     * @param used 二手车信息展示 0：未发布 1：发布未出售 2：发布未出售
     */
    public void setUsed(Integer used) {
        this.used = used;
    }
}