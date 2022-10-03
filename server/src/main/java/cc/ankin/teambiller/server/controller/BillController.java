package cc.ankin.teambiller.server.controller;

import cc.ankin.teambiller.server.dto.ResponseDto;
import cc.ankin.teambiller.server.entity.User;
import cc.ankin.teambiller.server.service.BillService;
import cc.ankin.teambiller.server.service.ResponseService;
import cc.ankin.teambiller.server.service.UserService;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("bill")
@RequestMapping("/api/bill")
public class BillController {
    @Resource
    UserService userService;
    @Resource
    BillService billService;

    @RequestMapping("/getUnpaidBill")
    public ResponseDto getUnpaidBill(@RequestHeader("email") String email) {
        User user = userService.getUserByEmail(email);
        Object obj = billService.getUnpaidBill(user);
        return ResponseService.ok(obj);
    }



}