package com.xg.demo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class HotelsRequest {
    @NotNull
    @ApiModelProperty(value = "酒店名称")
    String hotelname;

    @NotNull
    @ApiModelProperty(value = "经度")
    String longitude;

    @NotNull
    @ApiModelProperty(value = "维度")
    String dimensionality;

    @NotNull
    @ApiModelProperty(value = "省")
    String province;

    @NotBlank(message = "不能为空")
    @ApiModelProperty(value = "市")
    String city;

    @NotNull
    @ApiModelProperty(value = "街道")
    String street;

    @NotNull
    @ApiModelProperty(value = "电话号码")
    String phone;
}
