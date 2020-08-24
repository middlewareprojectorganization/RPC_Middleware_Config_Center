package com.xxy.rpc.rpc_middleware_config_center_plat.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("修改应用")
public class UpdateAppRequest {


    /**
     * 主键id
     */
    @NotNull
    @ApiModelProperty(value = "主键id", required = true)
    private Integer id;


    /**
     * app名称
     */
    @ApiModelProperty(value = "应用名称")
    private String appName;



}
