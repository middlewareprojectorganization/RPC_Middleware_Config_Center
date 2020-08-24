package com.xxy.rpc.rpc_middleware_config_center_plat.request;

import com.xxy.rpc.rpc_middleware_config_center_plat.common.ConfigTypeEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author: XXY
 * @Date: 2020/8/23 23:04
 */
@Data
public class ConfigRequest implements Serializable {
    private ConfigTypeEnum configTypeEnum;
    private String app;
    private Map<String, Object> params;
}
