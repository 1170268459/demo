package com.xg.demo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;


@Data
public class LoginByPasswordRequest {

    @NotNull
    @ApiModelProperty(value = "用户名")
    String username;

    @NotNull
    @ApiModelProperty(value="密码")
    String password;

}
