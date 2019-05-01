package club.zudianlv.pojo.vo;


public class UserVO {

    private String nickName;
    private Integer gender;
    private String avatarUrl;
    private String code;

    public UserVO() {
    }

    public UserVO(String nickName, Integer gender, String avatarUrl, String code) {
        this.nickName = nickName;
        this.gender = gender;
        this.avatarUrl = avatarUrl;
        this.code = code;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "nickName='" + nickName + '\'' +
                ", gender=" + gender +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
