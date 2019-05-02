package club.zudianlv.pojo;

import javax.persistence.*;

public class Rent {
    /**
     * 租车id
     */
    @Id
    @Column(name = "rent_id")
    private String rentId;

    /**
     * 用户 id
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * 赏金
     */
    private Integer money;

    /**
     * 0:可载人 1：不可 2：不限
     */
    private Integer manned;

    /**
     * 空闲时段表 id
     */
    @Column(name = "rent_time_id")
    private String rentTimeId;

    /**
     * 创建或修改时间：unix时间戳
     */
    private String time;

    /**
     * 车辆图片
     */
    @Column(name = "car_image")
    private String carImage;

    /**
     * 发布者昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 性别： 0：女 1：男
     */
    private Integer gender;

    /**
     * 发布者头像
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

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
     * 1：发布展示 2：发布未展示
     */
    private Integer rent;

    /**
     * 备注信息
     */
    private String message;

    /**
     * 获取租车id
     *
     * @return rent_id - 租车id
     */
    public String getRentId() {
        return rentId;
    }

    /**
     * 设置租车id
     *
     * @param rentId 租车id
     */
    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

    /**
     * 获取用户 id
     *
     * @return open_id - 用户 id
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置用户 id
     *
     * @param openId 用户 id
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取赏金
     *
     * @return money - 赏金
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * 设置赏金
     *
     * @param money 赏金
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

    /**
     * 获取0:可载人 1：不可 2：不限
     *
     * @return manned - 0:可载人 1：不可 2：不限
     */
    public Integer getManned() {
        return manned;
    }

    /**
     * 设置0:可载人 1：不可 2：不限
     *
     * @param manned 0:可载人 1：不可 2：不限
     */
    public void setManned(Integer manned) {
        this.manned = manned;
    }

    /**
     * 获取空闲时段表 id
     *
     * @return rent_time_id - 空闲时段表 id
     */
    public String getRentTimeId() {
        return rentTimeId;
    }

    /**
     * 设置空闲时段表 id
     *
     * @param rentTimeId 空闲时段表 id
     */
    public void setRentTimeId(String rentTimeId) {
        this.rentTimeId = rentTimeId;
    }

    /**
     * 获取创建或修改时间：unix时间戳
     *
     * @return time - 创建或修改时间：unix时间戳
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置创建或修改时间：unix时间戳
     *
     * @param time 创建或修改时间：unix时间戳
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取车辆图片
     *
     * @return car_image - 车辆图片
     */
    public String getCarImage() {
        return carImage;
    }

    /**
     * 设置车辆图片
     *
     * @param carImage 车辆图片
     */
    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }

    /**
     * 获取发布者昵称
     *
     * @return nick_name - 发布者昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置发布者昵称
     *
     * @param nickName 发布者昵称
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
     * 获取发布者头像
     *
     * @return avatar_url - 发布者头像
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * 设置发布者头像
     *
     * @param avatarUrl 发布者头像
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
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
     * 获取1：发布展示 2：发布未展示
     *
     * @return rent - 1：发布展示 2：发布未展示
     */
    public Integer getRent() {
        return rent;
    }

    /**
     * 设置1：发布展示 2：发布未展示
     *
     * @param rent 1：发布展示 2：发布未展示
     */
    public void setRent(Integer rent) {
        this.rent = rent;
    }

    /**
     * 获取备注信息
     *
     * @return message - 备注信息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置备注信息
     *
     * @param message 备注信息
     */
    public void setMessage(String message) {
        this.message = message;
    }
}