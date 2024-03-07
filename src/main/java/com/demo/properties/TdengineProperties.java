package com.demo.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author wuwenbo
 * @Date 2024/3/7 9:49
 * @ClassName: TdengineProperties
 * @Description: TODO
 */
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "tdengine")
public class TdengineProperties {

    /**
     * url
     */
    private String url;
    /**
     * 驱动名称
     */
    private String driverClassName;

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 数据库
     */
    private String database;
    /**
     * 超级表
     */
    private String superTable;

    /**
     * 最小的空闲连接数
     */
    private int minIdle;

    /**
     * 最大连接数
     */
    private int maxPoolSize;

    private long maxLifetime;

    /**
     * 测试连接查询
     */
    private String connectionTestQuery;

}
