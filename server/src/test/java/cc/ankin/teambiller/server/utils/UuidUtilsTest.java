package cc.ankin.teambiller.server.utils;

import cc.ankin.teambiller.server.utils.UuidUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UuidUtilsTest {

    @Test
    public void test() {
        System.out.println(UuidUtils.getUuid());
    }
}