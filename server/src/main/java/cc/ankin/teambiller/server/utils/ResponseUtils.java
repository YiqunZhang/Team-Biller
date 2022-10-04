package cc.ankin.teambiller.server.utils;

import cc.ankin.teambiller.server.dto.ResponseDto;
import org.springframework.stereotype.Service;

public class ResponseUtils {

    // 0 Ok
    public static ResponseDto ok(Object obj) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.code = 0;
        responseDto.obj = obj;
        responseDto.message = "成功";

        return responseDto;
    }

    // 1 NeedLogin
    public static ResponseDto needLogin(RuntimeException e) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.code = 1;
        responseDto.message = "需要登录";

        return responseDto;
    }

    // 2 NoPermission
    public static ResponseDto noPermission(RuntimeException e) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.code = 2;
        responseDto.message = "没有权限";
        return responseDto;
    }

    // 3 FailureLogin
    public static ResponseDto failureLogin(RuntimeException e) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.code = 3;
        responseDto.message = "登录失败";
        return responseDto;
    }

    // 8 Client Exception
    public static ResponseDto clientException(RuntimeException e) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.code = 8;
        responseDto.message = e.getMessage();
        return responseDto;
    }

    // 9 Exception
    public static ResponseDto serverException(RuntimeException e) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.code = 9;
        responseDto.message = "服务器错误";
        return responseDto;
    }

}
