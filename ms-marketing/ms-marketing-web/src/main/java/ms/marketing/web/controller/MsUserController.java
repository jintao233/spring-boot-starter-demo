package ms.marketing.web.controller;

import ms.user.api.dto.User;
import ms.user.api.rest.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author admin
 * @create 2022/5/9 15:21
 */
@RestController
public class MsUserController {

    final UserFeignClient userFeignClient;

    @Autowired
    public MsUserController(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    @GetMapping("/msUser/{userId}")
    public String getMsUserById(@PathVariable("userId") String userId) {
        User user = userFeignClient.getUserById(userId);
        if (Objects.isNull(user)) {
            return "hi 匿名者";
        }
        return "hi " + user.getUserName();
    }

}
