package cc.ankin.teambiller.server.controller;

import lombok.ToString;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("test")
@RequestMapping("/api")
public class TestController {

    @RequestMapping("/test")
    public String getList() {
        return "123";
    }

}
