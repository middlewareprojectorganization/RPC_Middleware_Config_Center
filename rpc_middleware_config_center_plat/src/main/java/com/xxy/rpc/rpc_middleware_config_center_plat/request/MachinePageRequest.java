package com.xxy.rpc.rpc_middleware_config_center_plat.request;

import com.xxy.rpc.rpc_middleware_config_center_plat.dto.MachineInfoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: XXY
 * @Date: 2020/5/31 0:19
 */
@Data
@ApiModel
public class MachinePageRequest {
    @ApiModelProperty("请求当前页")
    private Integer pageNum;
    @ApiModelProperty("每页大小")
    private Integer pageSize;
    @ApiModelProperty("请求条件")
    private MachineInfoDTO dto;
}
