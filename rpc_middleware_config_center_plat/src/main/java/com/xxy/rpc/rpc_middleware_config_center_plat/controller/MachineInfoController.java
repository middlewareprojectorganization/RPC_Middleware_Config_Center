package com.xxy.rpc.rpc_middleware_config_center_plat.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxy.rpc.rpc_middleware_config_center_plat.dto.MachineInfoDTO;
import com.xxy.rpc.rpc_middleware_config_center_plat.entity.MachineInfo;
import com.xxy.rpc.rpc_middleware_config_center_plat.request.MachinePageRequest;
import com.xxy.rpc.rpc_middleware_config_center_plat.service.MachineInfoService;
import com.xxy.rpc.rpc_middleware_config_center_plat.util.R;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

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
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！", response = R.class ),
            @ApiResponse(code = 500,message = "失败", response = R.class),
    })
    public R getMachineByPage(MachinePageRequest request){
        Page page = new Page(request.getPageNum(), request.getPageSize());
        MachineInfo info = new MachineInfo();
        BeanUtils.copyProperties(request.getDto(), info);
        return R.ok(machineInfoService.page(page, Wrappers.query(info)));
    }

    @DeleteMapping("/delete/{machineId}")
    @ApiOperation("机器删除接口")
    @ApiImplicitParam(name = "machineId", value = "机器id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功！", response = R.class ),
            @ApiResponse(code = 500,message = "失败", response = R.class),
    })
    public R removeMachine(@PathVariable("machineId") String machineId){
        MachineInfoDTO dto = new MachineInfoDTO();
        dto.setMachineId(machineId);
        MachineInfo info = new MachineInfo();
        BeanUtils.copyProperties(dto, info);
        return R.ok(machineInfoService.remove(Wrappers.query(info)));
    }
}
