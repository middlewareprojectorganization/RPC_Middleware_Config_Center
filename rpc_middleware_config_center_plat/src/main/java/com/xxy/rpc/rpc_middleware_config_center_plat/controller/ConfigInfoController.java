package com.xxy.rpc.rpc_middleware_config_center_plat.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxy.rpc.rpc_middleware_config_center_plat.config.enums.ConfigDefaultEnum;
import com.xxy.rpc.rpc_middleware_config_center_plat.entity.ConfigInfo;
import com.xxy.rpc.rpc_middleware_config_center_plat.request.AddConfigRequest;
import com.xxy.rpc.rpc_middleware_config_center_plat.request.BasePageRequest;
import com.xxy.rpc.rpc_middleware_config_center_plat.service.ConfigInfoService;
import com.xxy.rpc.rpc_middleware_config_center_plat.util.MyBeanUtils;
import com.xxy.rpc.rpc_middleware_config_center_plat.util.R;
import io.swagger.annotations.*;
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
@Api(tags = "配置管理相关接口")
@RestController
@RequestMapping("/config/info")
public class ConfigInfoController {

    @Resource
    private ConfigInfoService configInfoService;

    /**
     * 拉取默认配置
     * @return
     */
    @ApiOperation("获取默认配置")
    @GetMapping("/default/get")
    public R<ConfigInfo> getConfig(){
        QueryWrapper<ConfigInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("config_default", ConfigDefaultEnum.IS_DEFAULT.getStatus());
        ConfigInfo configInfo = configInfoService.getOne(queryWrapper);
        return R.ok(configInfo);
    }

    @PostMapping("/addConfig")
    @ApiOperation("增加配置")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！", response = R.class ),
            @ApiResponse(code = 500,message = "失败", response = R.class),
    })
    public R addConfig(@RequestBody @Valid AddConfigRequest request) {
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
    }


}
