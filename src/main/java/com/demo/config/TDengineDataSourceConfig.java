package com.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wuwenbo
 * @Date 2023/11/28 16:13
 * @ClassName: TDengineDataSourceConfig
 * @Description: TDengine 连接池
 */
@Configuration
public class TDengineDataSourceConfig {

    @Value("${tdEngine.url}")
    private String url;

    @Value("${tdEngine.driverClassName}")
    private String driverClassName;

    @Value("${tdEngine.username:}")
    private String username;

    @Value("${tdEngine.password:}")
    private String password;

    @Bean("tdEngineDataSource")
    public HikariDataSource tdEngineDataSource() {
        HikariConfig config = new HikariConfig();
        // jdbc properties
        config.setJdbcUrl(url);
        config.setDriverClassName(driverClassName);
        config.setUsername(username);
        config.setPassword(password);

        // connection pool configurations
        config.setMinimumIdle(10);           //minimum number of idle connection
        config.setMaximumPoolSize(10);      //maximum number of connection in the pool
        config.setConnectionTimeout(30000); //maximum wait milliseconds for get connection from pool
        config.setMaxLifetime(0);       // maximum life time for each connection
        config.setIdleTimeout(0);       // max idle time for recycle idle connection
        config.setConnectionTestQuery("select server_status()"); //validation query

        HikariDataSource ds = new HikariDataSource(config); //create datasource

        return ds;
    }

}
