package com.xxy.rpc.rpc_middleware_config_center_plat.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxy.rpc.rpc_middleware_config_center_plat.entity.AppInfo;
import com.xxy.rpc.rpc_middleware_config_center_plat.entity.ConfigInfo;
import com.xxy.rpc.rpc_middleware_config_center_plat.request.AddAppRequest;
import com.xxy.rpc.rpc_middleware_config_center_plat.request.AddConfigRequest;
import com.xxy.rpc.rpc_middleware_config_center_plat.request.BasePageRequest;
import com.xxy.rpc.rpc_middleware_config_center_plat.request.UpdateAppRequest;
import com.xxy.rpc.rpc_middleware_config_center_plat.service.AppInfoService;
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
import java.util.List;
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
@RequestMapping("/app-info")
public class AppInfoController {

    @Resource
    private AppInfoService appInfoService;

    @PostMapping("/addApp")
    @ApiOperation("增加应用")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！", response = R.class ),
            @ApiResponse(code = 500,message = "失败", response = R.class),
    })
    public R addApp(@RequestBody @Valid AddAppRequest request) {
        AppInfo appInfo = MyBeanUtils.copyPropertiesChaining(request, AppInfo::new);
        appInfo.setAppId(StringUtils.replace(UUID.randomUUID().toString(), "-", ""));
        appInfoService.save(appInfo);
        return R.ok();
    }

    @PostMapping("/updateApp")
    @ApiOperation("修改应用")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！", response = R.class ),
            @ApiResponse(code = 500,message = "失败", response = R.class),
    })
    public R registerService(@RequestBody UpdateAppRequest request) {
        AppInfo appInfo = MyBeanUtils.copyPropertiesChaining(request, AppInfo::new);
        appInfoService.updateById(appInfo);
        return R.ok();
    }

    @DeleteMapping("/removeApp/{id}")
    @ApiOperation("删除应用")
    @ApiImplicitParam(name = "id", value = "配置id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！", response = R.class ),
            @ApiResponse(code = 500,message = "失败", response = R.class),
    })
    public R removeConfig(@PathVariable("id") Integer id) {
        appInfoService.removeById(id);
        return R.ok();
    }

    @PostMapping("/pageConfig")
    @ApiOperation("分页查询应用")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！", response = R.class ),
            @ApiResponse(code = 500,message = "失败", response = R.class),
    })
    public R pageConfig(@RequestBody @Valid BasePageRequest request) {
        IPage<AppInfo> page = appInfoService.page(new Page<>(request.getPageNo(), request.getPageSize()));
        return R.ok(page);
    }

    @PostMapping("/listConfig")
    @ApiOperation("查询所有应用列表，绑定配置时使用")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！", response = R.class ),
            @ApiResponse(code = 500,message = "失败", response = R.class),
    })
    public R pageConfig() {
        List<AppInfo> list = appInfoService.list();
        return R.ok(list);
    }


}
