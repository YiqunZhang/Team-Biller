package cc.ankin.teambiller.server.controller;


import cc.ankin.teambiller.server.service.ResponseService;
import cc.ankin.teambiller.server.utils.exception.FailureLoginException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("user")
@RequestMapping("/api/user")
public class UserController {
    @Resource
    ResponseService responseService;

    @RequestMapping("/login")
    public Object login() throws Exception {
        Object obj = "123";
        return responseService.ok(obj);
    }

}
