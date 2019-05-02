package club.zudianlv.pojo.vo;

/**
 * @author yinren
 * @date 2019/5/2
 */
public class WxResult {

    private String openid;
    private String session_key;

    @Override
    public String toString() {
        return "WxResult{" +
                "openid='" + openid + '\'' +
                ", session_key='" + session_key + '\'' +
                '}';
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }
}
