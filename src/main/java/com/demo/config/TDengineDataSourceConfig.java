package com.demo.config;

import com.demo.properties.TdengineProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * @Author wuwenbo
 * @Date 2023/11/28 16:13
 * @ClassName: TDengineDataSourceConfig
 * @Description: TDengine 连接池
 */
@Configuration
@MapperScan(basePackages = "com.demo.dao.tdengine", sqlSessionTemplateRef = "tdengineSqlSessionTemplate", sqlSessionFactoryRef = "tdengineSqlSessionFactory")
public class TDengineDataSourceConfig {


    /**
     * 配置db2的数据源
     * @return
     */
    @Bean
    public DataSource tdengineDataSource(@Qualifier("tdengineProperties") TdengineProperties tdengineProperties) {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(tdengineProperties.getUrl());
        config.setDriverClassName(tdengineProperties.getDriverClassName());
        config.setUsername(tdengineProperties.getUsername());
        config.setPassword(tdengineProperties.getPassword());
        config.setMinimumIdle(tdengineProperties.getMinIdle());
        config.setMaximumPoolSize(tdengineProperties.getMaxPoolSize());
        config.setMaxLifetime(tdengineProperties.getMaxLifetime());
        config.setConnectionTestQuery(tdengineProperties.getConnectionTestQuery());

        HikariDataSource ds = new HikariDataSource(config); //create datasource
        return ds;
    }

    /**
     * 配置该数据源的sql会话工厂
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory tdengineSqlSessionFactory(@Qualifier("tdengineDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);

        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/demo/dao/tdengine/*.xml"));
        return bean.getObject();
    }


//    /**
//     * 配置该数据源的事务管理器
//     * @param dataSource
//     * @return
//     */
//    @Bean
//    public DataSourceTransactionManager db2TransactionManager(@Qualifier("db2DataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

    /**
     * 配置db2数据源的sql会话模板
     * @param sqlSessionFactory
     * @return
     */
    @Bean
    public SqlSessionTemplate tdengineSqlSessionTemplate(@Qualifier("tdengineSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


//    /**
//     * 配置db2数据源的事务模板
//     * @param dataSourceTransactionManager
//     * @return
//     */
//    @Bean
//    public TransactionTemplate db2TransactionTemplate(@Qualifier("db2TransactionManager") DataSourceTransactionManager dataSourceTransactionManager) {
//        return new TransactionTemplate(dataSourceTransactionManager);
//    }


}
