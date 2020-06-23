package com.xg.demo.Exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel("异常信息")
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError {
    @ApiModelProperty("异常code")
    private String code;

    @ApiModelProperty("异常信息")
    private String error;


}
