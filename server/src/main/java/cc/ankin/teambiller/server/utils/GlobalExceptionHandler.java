package cc.ankin.teambiller.server.utils;

import cc.ankin.teambiller.server.dto.ResponseDto;
import cc.ankin.teambiller.server.service.ResponseService;
import cc.ankin.teambiller.server.utils.exception.FailureLoginException;
import cc.ankin.teambiller.server.utils.exception.NeedLoginException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;

@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @Resource
    ResponseService responseService;


    @ExceptionHandler(Exception.class)
    public ResponseDto handleException(Exception e) {
        e.printStackTrace();
        return responseService.newResponseServerException(e);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseDto handleRuntimeException(Exception e) {
        e.printStackTrace();
        return responseService.newResponseServerException(e);
    }

    @ExceptionHandler(FailureLoginException.class)
    public ResponseDto failureLoginException(Exception e) {
        return responseService.failureLogin(e);
    }

    @ExceptionHandler(NeedLoginException.class)
    public ResponseDto needLoginException(Exception e) {
        return responseService.needLogin(e);
    }

//    @ResponseBody
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseDto handleResourceNotFoundException(ResourceNotFoundException e) throws Exception {
//        e.printStackTrace();
//        return responseService.newResponseClientException(e);
//    }

//    @ResponseBody
//    @ExceptionHandler(FieldInvalidException.class)
//    public ResponseDto handleFieldInvalidException(FieldInvalidException e) throws Exception {
//        e.printStackTrace();
//        return responseService.newResponseApplyInvalid(e);
//    }

//    @ResponseBody
//    @ExceptionHandler(ServerException.class)
//    public ResponseDto handleServerException(ServerException e) throws Exception {
//        e.printStackTrace();
//        return responseService.newResponseServerException(e);
//    }

//    @ResponseBody
//    @ExceptionHandler(SubmissionException.class)
//    public ResponseDto handleSubmissionException(SubmissionException e) throws Exception {
//        e.printStackTrace();
//        return responseService.newResponseClientException(e);
//    }

//    @ResponseBody
//    @ExceptionHandler(LogicException.class)
//    public ResponseDto handleLogicException(LogicException e) throws Exception {
//        return responseService.newLogicException(e);
//    }


}
