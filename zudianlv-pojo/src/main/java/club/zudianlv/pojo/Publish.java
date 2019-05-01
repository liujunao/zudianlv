package club.zudianlv.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Publish {
    /**
     * 想租车id
     */
    @Id
    @Column(name = "publish_id")
    private String publishId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 租车赏金
     */
    private Integer money;

    /**
     * 求租年月日： yyyy-MM-dd
     */
    private String yyyy;

    /**
     * 求租周几： 1->周一,2-->周二
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
     * 创建时间：unix 时间戳
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 发布者昵称
     */
    @Column(name = "nickName")
    private String nickname;

    /**
     * 发布者头像
     */
    @Column(name = "avatarUrl")
    private String avatarurl;

    /**
     * 发布者宿舍区：韵苑
     */
    private String area;

    /**
     * 发布者楼栋：16栋（传数字）
     */
    @Column(name = "area_num")
    private Integer areaNum;

    /**
     * 微信号
     */
    private String weixin;

    /**
     * 发布信息
     */
    private String message;

    /**
     * 获取想租车id
     *
     * @return publish_id - 想租车id
     */
    public String getPublishId() {
        return publishId;
    }

    /**
     * 设置想租车id
     *
     * @param publishId 想租车id
     */
    public void setPublishId(String publishId) {
        this.publishId = publishId;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取租车赏金
     *
     * @return money - 租车赏金
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * 设置租车赏金
     *
     * @param money 租车赏金
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

    /**
     * 获取求租年月日： yyyy-MM-dd
     *
     * @return yyyy - 求租年月日： yyyy-MM-dd
     */
    public String getYyyy() {
        return yyyy;
    }

    /**
     * 设置求租年月日： yyyy-MM-dd
     *
     * @param yyyy 求租年月日： yyyy-MM-dd
     */
    public void setYyyy(String yyyy) {
        this.yyyy = yyyy;
    }

    /**
     * 获取求租周几： 1->周一,2-->周二
     *
     * @return week - 求租周几： 1->周一,2-->周二
     */
    public Integer getWeek() {
        return week;
    }

    /**
     * 设置求租周几： 1->周一,2-->周二
     *
     * @param week 求租周几： 1->周一,2-->周二
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

    /**
     * 获取创建时间：unix 时间戳
     *
     * @return create_time - 创建时间：unix 时间戳
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间：unix 时间戳
     *
     * @param createTime 创建时间：unix 时间戳
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取发布者昵称
     *
     * @return nickName - 发布者昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置发布者昵称
     *
     * @param nickname 发布者昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取发布者头像
     *
     * @return avatarUrl - 发布者头像
     */
    public String getAvatarurl() {
        return avatarurl;
    }

    /**
     * 设置发布者头像
     *
     * @param avatarurl 发布者头像
     */
    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    /**
     * 获取发布者宿舍区：韵苑
     *
     * @return area - 发布者宿舍区：韵苑
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置发布者宿舍区：韵苑
     *
     * @param area 发布者宿舍区：韵苑
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取发布者楼栋：16栋（传数字）
     *
     * @return area_num - 发布者楼栋：16栋（传数字）
     */
    public Integer getAreaNum() {
        return areaNum;
    }

    /**
     * 设置发布者楼栋：16栋（传数字）
     *
     * @param areaNum 发布者楼栋：16栋（传数字）
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
     * 获取发布信息
     *
     * @return message - 发布信息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置发布信息
     *
     * @param message 发布信息
     */
    public void setMessage(String message) {
        this.message = message;
    }
}