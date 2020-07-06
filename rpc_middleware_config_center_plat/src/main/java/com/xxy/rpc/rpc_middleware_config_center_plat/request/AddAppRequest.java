package com.xxy.rpc.rpc_middleware_config_center_plat.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("增加应用")
public class AddAppRequest {


    /**
     * app名称
     */
    @NotNull(message = "app名称不能为空")
    @ApiModelProperty(value = "应用名称", required = true)
    private String appName;



}
