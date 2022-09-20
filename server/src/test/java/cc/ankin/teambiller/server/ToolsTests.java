package cc.ankin.teambiller.server;

import cc.ankin.teambiller.server.entity.User;
import cc.ankin.teambiller.server.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ToolsTests {
    @Resource
    UserService userService;

    @Test
    public void createUser() {
        User user = new User();
        user.name = "张逸群";
        user.email = "2223729465@qq.com";
        user.password = "123456";
        userService.add(user);

    }
}
