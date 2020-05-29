package com.xxy.rpc.rpc_middleware_config_center_plat.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: XXY
 * @Date: 2020/5/29 23:44
 */
@Data
@ApiModel
public class MachineInfoDTO {

    /**
     * 机器id
     */
    @ApiModelProperty(value = "机器id")
    private String machineId;

    /**
     * 机器名称
     */
    @ApiModelProperty(value = "机器name")
    private String machineName;

    /**
     * ip地址
     */
    @ApiModelProperty(value = "机器ip")
    private String ip;

    /**
     * 端口号
     */
    @ApiModelProperty("机器端口号")
    private Integer port;

    /**
     * 健康标识
     */
    @ApiModelProperty("健康标识，1为健康")
    private String healthFlag;

    /**
     * app_id
     */
    @ApiModelProperty("所属app应用id")
    private String appId;


}
