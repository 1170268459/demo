package com.xg.demo.controller;

import com.xg.demo.model.LoginByPasswordRequest;
import com.xg.demo.model.Users;
import com.xg.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "通过用户名和密码登录")
    @CrossOrigin("*")
    @GetMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity Login(){
        return  ResponseEntity.ok(userService.AddUser());
    }
}
