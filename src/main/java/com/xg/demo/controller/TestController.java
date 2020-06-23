package com.xg.demo.controller;

import com.xg.demo.Exception.BusinessException;
import com.xg.demo.Exception.ErrorType;
import com.xg.demo.service.I18nService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api")
public class TestController {
    @Autowired
    private  I18nService i18nService;



    @GetMapping("/test")
    public ResponseEntity test(){
        return ResponseEntity.ok(i18nService.getMessage("system.error"));
    }
    @GetMapping("/zz")
    public ResponseEntity zz(){
        if (2==2){
            throw  new BusinessException(ErrorType.SYSTEM_ERROR);
        }
        return ResponseEntity.ok().build();
    }
}
