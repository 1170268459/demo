package com.xg.demo.service;

import com.xg.demo.Exception.BusinessException;
import com.xg.demo.Exception.ErrorType;
import com.xg.demo.Utils.Md5Utils;
import com.xg.demo.api.ResponseCode;
import com.xg.demo.api.ResponseServer;
import com.xg.demo.mapper.UsersRepository;
import com.xg.demo.model.LoginByPasswordRequest;
import com.xg.demo.model.SystemUser;
import com.xg.demo.model.Users;
import com.xg.demo.redis.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;


@Slf4j
@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional(rollbackFor = Exception.class)
    public Users AddUser() {
        Users users = new Users();
        users.setName("qwe");
        users.setAge(25);
        users.setAddress("wqe");
        users.setUsername("123456");
        users.setPassword(Md5Utils.md5("123456"));
        Users save = usersRepository.save(users);
        String s = UUID.randomUUID().toString();
        redisUtil.set(s, users.getName());
        return save;
    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseServer loginByPassword(LoginByPasswordRequest login) {
        log.info("用户密码登录");
        Optional<Users> byUsernameAndPassword = usersRepository.getByUsernameAndPassword(login.getUsername(), Md5Utils.md5(login.getPassword()));
        if (byUsernameAndPassword.isPresent()) {
            String s = UUID.randomUUID().toString();
            redisUtil.set(s, byUsernameAndPassword.get().getId());
            return ResponseServer.createBySuccess(ResponseCode.SUCCESS.getValue(), ResponseCode.SUCCESS.getDesc(), s);
        } else {
            return ResponseServer.createByErrorCodeMessage(ResponseCode.FAIL.getValue(), ResponseCode.FAIL.getDesc());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public SystemUser loadSystemUserName(String username) {
        Optional<Users> byUsername = usersRepository.getByUsername(username);
        if (byUsername.isPresent()) {
            return new SystemUser(byUsername.get());
        } else {
            throw new BusinessException(ErrorType.USER_NOT_LOGIN);
        }
    }
}
