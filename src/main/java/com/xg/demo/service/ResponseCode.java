package com.xg.demo.service;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ResponseCode {
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"ERROR"),
    FAIL(201,"FAIL");
    private  final  int value;
    private final String desc;
}
