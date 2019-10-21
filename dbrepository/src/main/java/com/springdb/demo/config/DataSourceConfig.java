package com.springdb.demo.config;

import com.springdb.demo.config.dynamicdatasource.DynamicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjunshuai
 * @date 2019/10/16
 * @description
 **/
@Configuration
public class DataSourceConfig {

    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "primaryDataSourceRead")
    @Qualifier("primaryDataSourceRead")
    @ConfigurationProperties(prefix="spring.datasource.primary.read")
    public DataSource primaryDataSourceRead() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "dynamicDS1")
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(primaryDataSource());

        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap(5);
        dsMap.put("primaryDataSource", primaryDataSource());
        dsMap.put("primaryDataSourceRead", primaryDataSourceRead());

        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }

}
