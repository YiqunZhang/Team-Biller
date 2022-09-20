package cc.ankin.teambiller.server;

import cc.ankin.teambiller.server.entity.User;
import cc.ankin.teambiller.server.service.BillService;
import cc.ankin.teambiller.server.service.UserService;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ServerApplicationTests {
    @Resource
    private BillService billService;
    @Resource
    private UserService userService;


    @Test
    void contextLoads() {
    }

    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    void test() {
        mongoTemplate.save(new User());
    }

}
