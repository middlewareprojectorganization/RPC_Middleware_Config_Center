package com.xxy.rpc.rpc_middleware_config_center_plat.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxy.rpc.rpc_middleware_config_center_plat.dto.MachineInfoDTO;
import com.xxy.rpc.rpc_middleware_config_center_plat.entity.MachineInfo;
import com.xxy.rpc.rpc_middleware_config_center_plat.service.MachineInfoService;
import com.xxy.rpc.rpc_middleware_config_center_plat.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@Api(tags = "机器管理相关接口")
@RequestMapping("/machine")
@AllArgsConstructor
public class MachineInfoController {
    private final MachineInfoService machineInfoService;

    @GetMapping("/page")
    @ApiOperation("机器分页查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "每页大小", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "pageNum", value = "当前页", defaultValue = "20", required = true)
    }
    )
    public R getMachineByPage(int pageSize, int pageNum, MachineInfoDTO machineInfo){
        Page page = new Page(pageNum, pageSize);
        MachineInfo info = new MachineInfo();
        BeanUtils.copyProperties(machineInfo, info);
        return R.ok(machineInfoService.page(page, Wrappers.query(info)));
    }
}
