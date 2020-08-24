package com.xxy.rpc.rpc_middleware_config_center_plat.config.enums;

import lombok.Getter;

@Getter
public enum ConfigDefaultEnum {

    NOT_DEFAULT(0, "不是默认配置"),

    IS_DEFAULT(1, "是默认配置");

    private Integer status;

    private String message;

    ConfigDefaultEnum(Integer status, String Message) {
        this.status = status;
        this.message = message;
    }
}
