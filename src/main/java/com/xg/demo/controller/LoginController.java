package com.xg.demo.controller;

import com.xg.demo.model.request.LoginByPasswordRequest;
import com.xg.demo.service.UserService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class LoginController {


    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity Login(@RequestBody @Valid @ApiParam(value = "登录信息") LoginByPasswordRequest login, BindingResult bindingResult) {
        return ResponseEntity.ok(userService.loginByPassword(login));
    }

}
