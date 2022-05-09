package ms.user.configuration;

import ms.user.api.rest.UserFeignClient;
import ms.user.api.rest.UserFeignMarker;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author admin
 * @create 2022/5/9 02:52
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(UserFeignMarker.class)
@EnableFeignClients(basePackageClasses = UserFeignMarker.class)
@EnableConfigurationProperties(MsUserConnectionConfiguration.class)
@Import({UserFeignClient.UserFallbackFactory.class})
public class MsUserAutoConfiguration {
}
