package com.xg.demo.mapper;

import com.xg.demo.model.LoginByPasswordRequest;
import com.xg.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Integer> {

    Optional<Users> getByUsernameAndPassword(String  username,String password);

    Optional<Users> getByUsername(String username);
}
