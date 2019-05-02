package club.zudianlv.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author yinren
 * @date 2019/5/1
 */
@Configuration
@ConfigurationProperties(prefix = "club.zudianlv")
@PropertySource("classpath:resource.properties")
public class ResourceConfig {
    private String fileSpace;
    private String appId;
    private String appSecret;


    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getFileSpace() {
        return fileSpace;
    }

    public void setFileSpace(String fileSpace) {
        this.fileSpace = fileSpace;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
