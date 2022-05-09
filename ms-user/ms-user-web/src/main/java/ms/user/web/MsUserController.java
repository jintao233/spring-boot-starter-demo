package ms.user.web;

import ms.user.api.dto.User;
import ms.user.api.rest.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @create 2022/5/9 02:07
 */
@RestController
public class MsUserController implements UserFeignClient {
    private static final Map<String, User> users = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(MsUserController.class);

    static {
        users.put("10010", new User("10010", "张三"));
        users.put("10086", new User("10086", "李四"));
    }

    @Override
    public User getUserById(String userId) {
        logger.info("[ms-user:MsUserController:getUserById:{}]", userId);
        return users.get(userId);
    }
}
