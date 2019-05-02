package club.zudianlv.pojo;

import javax.persistence.*;

public class User {
    /**
     * 用户 ID，通过微信获得
     */
    @Id
    @Column(name = "open_id")
    private String openId;

    /**
     * 用于保存 session_key，当用户信息变化时，更新该字段值
     */
    @Column(name = "session_key")
    private String sessionKey;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 性别： 0：女 1：男
     */
    private Integer gender;

    /**
     * 头像
     */
    @Column(name = "avatar_url")
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

    //注册或登陆出错，返回 -1
    public User(String openId) {
        this.openId = openId;
    }

    //注册时，保存用户信息: rent 与 userd 默认为 0
    public User(String openId, String sessionKey, String nickName, Integer gender, String avatarUrl, Integer rent, Integer used) {
        this.openId = openId;
        this.sessionKey = sessionKey;
        this.nickName = nickName;
        this.gender = gender;
        this.avatarUrl = avatarUrl;
        this.rent = rent;
        this.used = used;
    }

    //用户信息改变时，用于更新
    public User(String openId, String sessionKey, String nickName, Integer gender, String avatarUrl) {
        this.openId = openId;
        this.sessionKey = sessionKey;
        this.nickName = nickName;
        this.gender = gender;
        this.avatarUrl = avatarUrl;
    }

    //完善用户信息
    public User(String openId, String college, String grade, String area, Integer areaNum, String weixin) {
        this.openId = openId;
        this.college = college;
        this.grade = grade;
        this.area = area;
        this.areaNum = areaNum;
        this.weixin = weixin;
    }

    //上传学生证照片
    public User(String openId, String hustImage) {
        this.openId = openId;
        this.hustImage = hustImage;
    }

    /**
     * 获取用户 ID，通过微信获得
     *
     * @return open_id - 用户 ID，通过微信获得
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置用户 ID，通过微信获得
     *
     * @param openId 用户 ID，通过微信获得
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取用于保存 session_key，当用户信息变化时，更新该字段值
     *
     * @return session_key - 用于保存 session_key，当用户信息变化时，更新该字段值
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * 设置用于保存 session_key，当用户信息变化时，更新该字段值
     *
     * @param sessionKey 用于保存 session_key，当用户信息变化时，更新该字段值
     */
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    /**
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
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
     * @return avatar_url - 头像
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