package club.zudianlv.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Used {
    /**
     * 二手车id
     */
    @Id
    @Column(name = "used_id")
    private String usedId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 二手车图片
     */
    @Column(name = "used_image")
    private String usedImage;

    /**
     * 出手金额
     */
    private Integer money;

    /**
     * 创建时间：unix时间戳
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
     * 获取二手车id
     *
     * @return used_id - 二手车id
     */
    public String getUsedId() {
        return usedId;
    }

    /**
     * 设置二手车id
     *
     * @param usedId 二手车id
     */
    public void setUsedId(String usedId) {
        this.usedId = usedId;
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
     * 获取二手车图片
     *
     * @return used_image - 二手车图片
     */
    public String getUsedImage() {
        return usedImage;
    }

    /**
     * 设置二手车图片
     *
     * @param usedImage 二手车图片
     */
    public void setUsedImage(String usedImage) {
        this.usedImage = usedImage;
    }

    /**
     * 获取出手金额
     *
     * @return money - 出手金额
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * 设置出手金额
     *
     * @param money 出手金额
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

    /**
     * 获取创建时间：unix时间戳
     *
     * @return create_time - 创建时间：unix时间戳
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间：unix时间戳
     *
     * @param createTime 创建时间：unix时间戳
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