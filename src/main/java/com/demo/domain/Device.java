package com.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author tianwenjun
 * @since 2023-07-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("app_device")
@ApiModel(value="Device对象", description="设备数据实体")
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("设备主键ID")
    @TableId(value = "device_id", type = IdType.AUTO)
    private Long deviceId;

    @TableField(value = "user_id")
    @ApiModelProperty("用户id-关联设备")
    private Long userId;

    @TableField(value = "device_name")
    @ApiModelProperty("设备名称")
    private String deviceName;

    @TableField(value = "device_version_name")
    @ApiModelProperty("设备的版本（APP端显示版本）")
    private String deviceVersionName;

    @TableField(value = "device_number")
    @ApiModelProperty("设备序列号（SN号）")
    private String deviceNumber;

    @TableField(value = "device_image")
    @ApiModelProperty("设备图片")
    private String deviceImage;

    @TableField(value = "longitude")
    @ApiModelProperty("经度")
    private String longitude;

    @TableField(value = "latitude")
    @ApiModelProperty("纬度")
    private String latitude;

    @TableField(value = "create_time")
    @ApiModelProperty("注册时间")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    @ApiModelProperty("更改时间")
    private LocalDateTime updateTime;

    @TableField(value = "status")
    @ApiModelProperty("设备状态：字典类型1003")
    private String status;

    @TableField(value = "dc_main_fw_code")
    @ApiModelProperty("DC控制板固件版本code")
    private String dcMainFwCode;

    @TableField(value = "dc_main_hw_code")
    @ApiModelProperty("DC控制板硬件版本code")
    private String dcMainHwCode;

    @TableField(value = "dc_power_fw_code")
    @ApiModelProperty("DC功率板固件版本code")
    private String dcPowerFwCode;

    @TableField(value = "dc_power_hw_code")
    @ApiModelProperty("DC功率板硬件版本code")
    private String dcPowerHwCode;

    @TableField(value = "inverter_fw_code")
    @ApiModelProperty("逆变板固件版本code")
    private String inverterFwCode;

    @TableField("inverter_hw_code")
    @ApiModelProperty("逆变板硬件版本code")
    private String inverterHwCode;

    @TableField("wl_fw_code")
    @ApiModelProperty("WL固件版本code")
    private String wlFwCode;

    @TableField("wl_hw_code")
    @ApiModelProperty("WL硬件版本code")
    private String wlHwCode;

    @TableField("dc_bms_fw_code")
    @ApiModelProperty("bms 固件版本code")
    private String dcBmsFwCode;

    @TableField("dc_bms_hw_code")
    @ApiModelProperty("bms硬件版本code")
    private String dcBmsHwCode;

    @TableField("position")
    @ApiModelProperty("位置 从0开始")
    private Integer position;

    @TableField("pd_type")
    @ApiModelProperty("产品类型，1：F3600，2：B3600，3：F2400，4：B2400")
    private Integer pdType;

    @TableField("upgrade_status")
    @ApiModelProperty("ota升级状态：1：待升级，2：升级中，3：升级成功，4：升级失败")
    private Integer upgradeStatus;

}
