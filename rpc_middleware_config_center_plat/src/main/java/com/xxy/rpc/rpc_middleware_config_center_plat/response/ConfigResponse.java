package com.xxy.rpc.rpc_middleware_config_center_plat.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: XXY
 * @Date: 2020/8/23 23:05
 */
@Data
public class ConfigResponse implements Serializable {
    private String content;
    private String error;
}
