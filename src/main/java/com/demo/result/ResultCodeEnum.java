package com.demo.result;

import lombok.Getter;

/**
 * 统一返回结果状态信息类
 */
@Getter
public enum ResultCodeEnum {
    //用户验证
    USER_EXIST(300,"系统中已存该账户，如果您想继续注册，请提供其他账号！"),
    CODE_ERROR(301, "验证码错误,请确认后输入！"),
    LOGIN_MOBLE_ERROR(302, "账号不正确,或不存在请确认后输入！"),
    LOGIN_PASSWORD_ERROR(303, "密码不正确，请确认后输入！"),
    USER_NO_EXIST(304,"系统中不存在该用户，请检查账号是否正确！"),
    REMOVE_ERROR(305, "你注销的用户不存在！"),
    USER_BIND_EXIST(306,"系统中存在该用户，不能重复绑定！"),
    USER_PASSWORD_ERROR(307,"密码错误，请从新输入！"),
    //设备管理
    DEVICE_NOT_EXIST(308,"设备不存在，请确认！"),
    DEVICE_DELETE_EXCEPTION(309,"设备删除异常，请联系管理员！"),
    DEVICE_UPDATE_EXCEPTION(410,"设备更新异常，请联系管理员！"),
    DEVICE_UNBINDING_EXIST(411,"解绑设备不存在！"),
    DEVICE_UNBINDING_EXCEPTION(412,"设备未绑定不能解绑操作！"),
    DEVICE_BINDING_EXIST(413,"该设备已经绑定，请解绑后重试！"),
    ISSUE_CMD_ERROR(414,"系统下发命令失败！"),
    DEVICE_BINDING_FAIL(415,"该设备未注册，请注册后再试！"),
    DEVICE_EXIST(416,"设备已存在，不能重复注册！"),
    DEVICE_RECOVER(418,"设备已经绑定当前用户，则不进行重复绑定！"),
    BMS_REPEAT_ERROR(419,"设备SN号不能重复!"),


    /**重复提交**/
    RESUBMIT_ERROR(417,"请勿重复点击，建议您稍后再试!"),

    //好友管理
    INVITATION_CODE_NOT_EXIST(420,"邀请码不存在或已被使用，请重试！"),

    FRIEND_NOT_EXIST(421,"该好友不存在，请重试！"),

    FRIEND_ERROR(422,"请勿邀请自己！"),
    FRIEND_EXISTED(423,"请勿重复邀请好友！"),


    //文件上传
    SUCCESS(200,"成功"),
    FAIL(201, "失败"),
    PARAM_ERROR( 202, "参数不正确"),
    SERVICE_ERROR(203, "服务异常"),
    DATA_ERROR(204, "数据异常"),
    DATA_UPDATE_ERROR(205, "数据版本异常"),

    MESSAGE_NOT_EXPIRED(206,"验证码未过期，请重新输入！"),
    FIRMWARE_EXISTED(207,"固件已存在！"),

    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限"),

    NOT_BIND(210, "设备没有绑定用户，不能升级！"),

    TOKEN_IS_NULL(220,"token为空，请重新登录"),
    TOKEN_IS_NO(221,"token无效，请重新登录"),
    TOKEN_IS_EXPIRE(222,"未登录或登录已过期"),



    LOGIN_NULL_ERROR(214, "账号不能为空"),

    LOGIN_DISABLED_ERROR(212, "该用户已被禁用"),
    REGISTER_MOBLE_ERROR(213, "手机号已被使用"),
    LOGIN_AURH(214, "需要登录"),
    LOGIN_ACL(215, "没有权限"),

    URL_ENCODE_ERROR( 216, "URL编码失败"),
    ILLEGAL_CALLBACK_REQUEST_ERROR( 217, "非法回调请求"),
    FETCH_ACCESSTOKEN_FAILD( 218, "获取accessToken失败"),
    FETCH_USERINFO_ERROR( 219, "获取用户信息失败"),

    PARAM_MISSING_ERROR(220,"请求参数缺失"),

    LOGIN_ERROR( 23005, "登录失败"),

    // 验证码
    CODE_EXIST(424,"验证码已发送，请勿重复发送，1分钟后重试!"),
    CODE_LIMIT(425,"操作过于频繁，请30分钟后重试!"),


    //数据删除枚举
    NOT_DATA_ID(426,"您删除的数据不存在!"),

    OTA_IS_RUNNING(427,"设备正在升级中，请稍后操作！"),

    POWER_DELETE_ERROR(428,"设备离线，不能删除省电方案！");


    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
