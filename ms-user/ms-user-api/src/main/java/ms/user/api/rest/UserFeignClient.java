package ms.user.api.rest;

import ms.user.api.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author admin
 * @create 2022/5/9 02:22
 */
@FeignClient(name = "ms-user", url = "${ms-user.url:127.0.0.1:8080}",
        fallbackFactory = UserFeignClient.UserFallbackFactory.class)
public interface UserFeignClient {

    @GetMapping("/user/{userId}")
    @ResponseBody
    User getUserById(@PathVariable("userId") String userId);

    class UserFallbackFactory implements FallbackFactory<UserFeignClient> {
        private final Logger logger = LoggerFactory.getLogger(UserFallbackFactory.class);

        @Override
        public UserFeignClient create(Throwable cause) {
            return userId -> {
                logger.error("ms-user服务异常", cause);
                return null;
            };
        }
    }
}
