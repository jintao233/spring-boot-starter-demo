package ms.user.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author admin
 * @create 2022/5/9 02:53
 */
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "ms-user")
public class MsUserConnectionConfiguration {

    private String url = "127.0.0.1:8080";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
