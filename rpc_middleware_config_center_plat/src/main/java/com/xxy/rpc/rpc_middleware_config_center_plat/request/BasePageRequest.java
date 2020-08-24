package com.xxy.rpc.rpc_middleware_config_center_plat.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Description:
 * Create DateTime: 2020/3/27 19:03
 *
 * @author yuange
 */
@Data
public class BasePageRequest  {

    @NotNull(message = "必填字段为空")
    @ApiModelProperty(required = true)
    private Long pageSize;

    @NotNull(message = "必填字段为空")
    @ApiModelProperty(required = true)
    private Long pageNo;

}
