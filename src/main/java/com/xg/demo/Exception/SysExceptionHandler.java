package com.xg.demo.Exception;

import com.xg.demo.service.I18nService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class SysExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ResponseError> businessExceptionHandler(BusinessException ex, HttpServletRequest request){
        log.info("业务逻辑异常处理，SysExceptionHandler会去监控BusinessException异常");
        ResponseError error=new ResponseError(ex.getErrorType().getErrorCode(), I18nService.getMessage(ex.getErrorType().getErrorKey()));
        return ResponseEntity.badRequest().body(error);
    }

}
