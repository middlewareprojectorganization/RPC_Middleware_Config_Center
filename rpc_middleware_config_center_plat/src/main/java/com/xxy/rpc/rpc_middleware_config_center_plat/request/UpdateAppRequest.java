package com.xxy.rpc.rpc_middleware_config_center_plat.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("增加应用")
public class UpdateAppRequest {


    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private String id;


    /**
     * app名称
     */
    @ApiModelProperty(value = "应用名称")
    private String appName;



}
