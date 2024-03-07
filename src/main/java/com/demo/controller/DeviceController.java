package com.demo.controller;

import com.demo.domain.Device;
import com.demo.result.Result;
import com.demo.service.DeviceService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author wuwenbo
 * @Date 2024/3/6 16:37
 * @ClassName: DeviceController
 * @Description: TODO
 */
@RestController
@RequestMapping("/device")
public class DeviceController {

    @Resource
    private DeviceService deviceService;

    @GetMapping("/detail")
    @ApiOperation("设备详情")
    @ApiImplicitParam(name = "deviceId",value = "设备编号",required = true)
    public Result<Device> detail(@RequestParam Long deviceId){
        return deviceService.detail(deviceId);
    }

    @GetMapping("/unBinding")
    @ApiOperation("设备解绑")
    @ApiImplicitParam(name = "deviceId",value = "设备ID",required = true)
    public Result unBinding(@RequestParam Long deviceId){
        return deviceService.unBinding(deviceId);
    }

}
