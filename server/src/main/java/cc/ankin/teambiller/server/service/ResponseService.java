package cc.ankin.teambiller.server.service;

import cc.ankin.teambiller.server.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    // 0 Ok
    public static ResponseDto ok(Object obj) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.code = 0;
        responseDto.obj = obj;
        responseDto.message = "成功";

        return responseDto;
    }

    // 1 NeedLogin
    public static ResponseDto needLogin(Exception e) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.code = 1;
        responseDto.message = "需要登录";

        return responseDto;
    }

    // 2 NoPermission
    public static ResponseDto noPermission(Exception e) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.code = 2;
        responseDto.message = "没有权限";
        return responseDto;
    }

    // 3 FailureLogin
    public static ResponseDto failureLogin(Exception e) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.code = 3;
        responseDto.message = "登录失败";
        return responseDto;
    }

    // 4 Apply Invalid
    public static ResponseDto applyInvalid(Exception e) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.code = 4;
        responseDto.message = "请求不合法";
        return responseDto;
    }

    // 5 Logic Exception
    public static ResponseDto logicException(Exception e) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.code = 5;
        responseDto.message = "逻辑错误";
        return responseDto;
    }

    // 8 Client Exception
    public static ResponseDto newResponseClientException(Exception e) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.code = 8;
        responseDto.message = "客户端错误";
        return responseDto;
    }

    // 9 Exception
    public static ResponseDto newResponseServerException(Exception e) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.code = 9;
        responseDto.message = "服务器错误";
        return responseDto;
    }

}
