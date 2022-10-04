package cc.ankin.teambiller.server.controller;


import cc.ankin.teambiller.server.dto.ResponseDto;
import cc.ankin.teambiller.server.utils.ResponseUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/user")
public class UserController {

    @RequestMapping("/login")
    public ResponseDto login() throws Exception {
        Object obj = "123";
        return ResponseUtils.ok(obj);
    }

}
