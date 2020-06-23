package com.xg.demo.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum  ErrorType {
    SYSTEM_ERROR    ("#0000001","system.error"),
    USER_NOT_LOGIN  ("#0000002","user.not.login"),
    USER_NOT_EXIST  ("#0000003","user.not.exist");

    private String errorCode;
    private String errorKey;
}
