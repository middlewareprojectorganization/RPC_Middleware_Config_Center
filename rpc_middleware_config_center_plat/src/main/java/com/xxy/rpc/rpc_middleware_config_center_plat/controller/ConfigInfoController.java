package com.xxy.rpc.rpc_middleware_config_center_plat.controller;


import com.xxy.rpc.rpc_middleware_config_center_plat.dto.ConfigInfoDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author vicente
 * @since 2020-05-29
 */
@Api(tags = "配置管理相关接口")
@RestController
@RequestMapping("/config/info")
public class ConfigInfoController {
    public void addConfig(ConfigInfoDTO configInfoDTO){

    }



}
