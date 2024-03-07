package com.demo.dao.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.domain.Device;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 设备表 Mapper 接口
 * </p>
 *
 * @author tianwenjun
 * @since 2023-07-03
 */
public interface DeviceMapper extends BaseMapper<Device> {

    int unbind(@Param("deviceId") Long deviceId);

    void updateDeviceStatus(@Param("deviceNumber")String deviceNumber, @Param("status")String status);
}
