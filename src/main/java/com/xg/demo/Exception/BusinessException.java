package com.xg.demo.Exception;

import com.xg.demo.service.I18nService;
import lombok.Data;

@Data
public class BusinessException extends RuntimeException {

    private ErrorType errorType;

    public BusinessException(ErrorType errorType) {
        super(I18nService.getMessage(errorType.getErrorKey()));
        this.errorType = errorType;
    }

    public BusinessException(Throwable cause, ErrorType errorType) {
        super(I18nService.getMessage(errorType.getErrorKey()));
        this.errorType = errorType;
    }
}
