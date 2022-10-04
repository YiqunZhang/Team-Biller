package cc.ankin.teambiller.server.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TranslateServiceTest {
    @Resource
    private TranslateService translateService;

    @Test
    public void translate() throws Exception {
        String result = translateService.translate("hello world");
        System.out.println(result);
    }
}
