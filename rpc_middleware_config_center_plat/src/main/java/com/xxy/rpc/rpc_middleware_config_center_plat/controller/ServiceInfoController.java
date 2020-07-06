package com.xxy.rpc.rpc_middleware_config_center_plat.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxy.rpc.rpc_middleware_config_center_plat.config.enums.ConfigDefaultEnum;
import com.xxy.rpc.rpc_middleware_config_center_plat.entity.ConfigInfo;
import com.xxy.rpc.rpc_middleware_config_center_plat.request.AddConfigRequest;
import com.xxy.rpc.rpc_middleware_config_center_plat.request.BasePageRequest;
import com.xxy.rpc.rpc_middleware_config_center_plat.service.ConfigInfoService;
import com.xxy.rpc.rpc_middleware_config_center_plat.service.ServiceInfoService;
import com.xxy.rpc.rpc_middleware_config_center_plat.util.MyBeanUtils;
import com.xxy.rpc.rpc_middleware_config_center_plat.util.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author vicente
 * @since 2020-05-29
 */
@RestController
@RequestMapping("/service-info")
public class ServiceInfoController {

    @Resource
    private ServiceInfoService serviceInfoService;


    /*@PostMapping("/registerService")
    @ApiOperation("注册服务")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！", response = R.class ),
            @ApiResponse(code = 500,message = "失败", response = R.class),
    })
    public R registerService(@RequestBody @Valid AddConfigRequest request) {
        ConfigInfo configInfo = MyBeanUtils.copyPropertiesChaining(request, ConfigInfo::new);
        configInfo.setConfigId(StringUtils.replace(UUID.randomUUID().toString(), "-", ""));
        configInfoService.save(configInfo);
        return R.ok();
    }

    @DeleteMapping("/removeConfig/{id}")
    @ApiOperation("删除配置")
    @ApiImplicitParam(name = "id", value = "配置id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！", response = R.class ),
            @ApiResponse(code = 500,message = "失败", response = R.class),
    })
    public R removeConfig(@PathVariable("id") Integer id) {
        configInfoService.removeById(id);
        return R.ok();
    }

    @PostMapping("/pageConfig")
    @ApiOperation("分页查询配置")
    @ApiImplicitParam(name = "id", value = "配置id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！", response = R.class ),
            @ApiResponse(code = 500,message = "失败", response = R.class),
    })
    public R pageConfig(@RequestBody @Valid BasePageRequest request) {
        IPage<ConfigInfo> page = configInfoService.page(new Page<>(request.getPageNo(), request.getPageSize()));
        return R.ok(page);
    }*/


}
