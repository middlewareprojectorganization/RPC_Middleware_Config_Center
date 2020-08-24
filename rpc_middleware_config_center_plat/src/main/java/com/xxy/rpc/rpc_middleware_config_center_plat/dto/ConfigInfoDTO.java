package com.xxy.rpc.rpc_middleware_config_center_plat.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: XXY
 * @Date: 2020/6/13 21:44
 */
@Data
@ApiModel
public class ConfigInfoDTO {

    /**
     * 配置id
     */
    @ApiModelProperty(value = "配置id")
    private String configId;

    /**
     * 配置内容
     */
    @ApiModelProperty(value = "配置内容")
    private String configContent;

    /**
     * 配置名称
     */
    @ApiModelProperty(value = "配置名称")
    private String configName;
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;
    @ApiModelProperty("修改时间")
    private LocalDateTime gmtModified;

    @ApiModelProperty("配置类型：全局配置，单个配置")
    private String configType;


}
