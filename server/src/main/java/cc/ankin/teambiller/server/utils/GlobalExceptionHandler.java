package cc.ankin.teambiller.server.utils;

import cc.ankin.teambiller.server.dto.ResponseDto;
import cc.ankin.teambiller.server.utils.exception.ClientException;
import cc.ankin.teambiller.server.utils.exception.FailureLoginException;
import cc.ankin.teambiller.server.utils.exception.NeedLoginException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;

@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseDto handleException(RuntimeException e) {
        e.printStackTrace();
        return ResponseUtils.serverException(e);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseDto handleRuntimeException(RuntimeException e) {
        e.printStackTrace();
        return ResponseUtils.serverException(e);
    }

    @ExceptionHandler(FailureLoginException.class)
    public ResponseDto failureLoginException(RuntimeException e) {
        return ResponseUtils.failureLogin(e);
    }

    @ExceptionHandler(NeedLoginException.class)
    public ResponseDto needLoginException(RuntimeException e) {
        return ResponseUtils.needLogin(e);
    }

    @ResponseBody
    @ExceptionHandler(ClientException.class)
    public ResponseDto handleClientException(ClientException e) throws Exception {
        e.printStackTrace();
        return ResponseUtils.clientException(e);
    }


}
