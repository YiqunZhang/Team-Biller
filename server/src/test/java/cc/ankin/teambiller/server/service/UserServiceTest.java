package cc.ankin.teambiller.server.service;

import cc.ankin.teambiller.server.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserServiceTest {
    @Resource
    UserService userService;

    @Test
    public void add() {
        User user = new User();

        user.name = "汤润泽";
        user.email = "tang@qq.com";
        user.password = "123456";
        userService.add(user);
    }

}
