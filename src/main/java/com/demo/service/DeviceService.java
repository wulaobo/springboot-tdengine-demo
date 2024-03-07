package com.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.dao.mysql.DeviceMapper;
import com.demo.domain.Device;
import com.demo.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author wuwenbo
 * @Date 2024/3/6 16:39
 * @ClassName: DeviceService
 * @Description: TODO
 */
@Service
@Slf4j
public class DeviceService extends ServiceImpl<DeviceMapper, Device> {

    @Resource
    private DeviceMapper deviceMapper;

    public Result<Device> detail(Long deviceId) {
        Device device = deviceMapper.selectById(deviceId);
        return Result.ok(device);
    }

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public Result unBinding(Long deviceId) {

        deviceMapper.unbind(deviceId);
        int i = 1/0;
        return Result.ok();
    }

}
