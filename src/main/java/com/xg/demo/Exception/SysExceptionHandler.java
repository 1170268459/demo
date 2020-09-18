package com.xg.demo.Exception;

import com.alibaba.fastjson.JSON;
import com.xg.demo.service.I18nService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class SysExceptionHandler extends ResponseEntityExceptionHandler {

    public static String getMessage(HttpServletRequest request){
        String message="url={0} \nmethod={1}\nheaders={2}\nqueryParameters={3}\nbody={4}";

        //headers
        Enumeration<String> headerNames = request.getHeaderNames();
        Map<String,String> headers=new HashMap<>();
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            headers.put(name,request.getHeader(name));
        }
        //queryParameters
        Map<String, String[]> queryParameters = request.getParameterMap();

        //body
        String body="";
        if (request instanceof ContentCachingRequestWrapper) {
            ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) request;
            body= StringUtils.toEncodedString(wrapper.getContentAsByteArray(), Charset.forName(wrapper.getCharacterEncoding()));
        }
        return MessageFormat.format(message,
                request.getRequestURL(),
                request.getMethod(),
                JSON.toJSONString(headers),
                JSON.toJSONString(queryParameters),
                body);
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ResponseError> businessExceptionHandler(BusinessException ex, HttpServletRequest request){
        log.info("业务逻辑异常处理，SysExceptionHandler会去监控BusinessException异常");
        ResponseError error=new ResponseError(ex.getErrorType().getErrorCode(), I18nService.getMessage(ex.getErrorType().getErrorKey()));
        return ResponseEntity.badRequest().body(error);
    }

}
