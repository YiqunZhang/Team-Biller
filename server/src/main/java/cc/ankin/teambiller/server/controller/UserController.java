package cc.ankin.teambiller.server.controller;


import cc.ankin.teambiller.server.dto.ResponseDto;
import cc.ankin.teambiller.server.service.ResponseService;
import cc.ankin.teambiller.server.utils.exception.FailureLoginException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("user")
@RequestMapping("/api/user")
public class UserController {

    @RequestMapping("/login")
    public ResponseDto login() throws Exception {
        Object obj = "123";
        return ResponseService.ok(obj);
    }

}
