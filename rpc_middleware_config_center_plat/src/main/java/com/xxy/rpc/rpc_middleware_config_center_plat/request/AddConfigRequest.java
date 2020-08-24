package com.xxy.rpc.rpc_middleware_config_center_plat.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("用户实体类")
public class AddConfigRequest {


    /**
     * 配置内容
     */
    @NotNull(message = "配置内容不能为空")
    @ApiModelProperty(required = true, value = "配置内容")
    private String configContent;

    /**
     * 配置名称
     */
    @NotNull(message = "配置名不能为空")
    @ApiModelProperty(required = true, value = "配置名称")
    private String configName;


}
