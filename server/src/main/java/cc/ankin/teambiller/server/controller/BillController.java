package cc.ankin.teambiller.server.controller;

import cc.ankin.teambiller.server.dto.ResponseDto;
import cc.ankin.teambiller.server.entity.User;
import cc.ankin.teambiller.server.service.BillService;
import cc.ankin.teambiller.server.utils.ResponseUtils;
import cc.ankin.teambiller.server.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController()
@RequestMapping("/api/bill")
public class BillController {
    @Resource
    UserService userService;
    @Resource
    BillService billService;

    @RequestMapping("/getBillListByUser")
    public ResponseDto getUnpaidBill(@RequestHeader("email") String email, @RequestBody List<Integer> statusList) {
        User user = userService.getUserByEmail(email);
        Object obj = billService.getBillListByUser(user, statusList);
        return ResponseUtils.ok(obj);
    }






}
