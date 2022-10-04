package cc.ankin.teambiller.server.service;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class SettingServiceTest {
    @Resource
    private SettingService settingService;

    @Test
    public void add() {
        settingService.add("aliyun.accessKeySecret", "test");
    }

    @Test
    public void getString() {
        String value = settingService.getString("aliyun.accessKeySecret");
        System.out.println(value);
    }

}
