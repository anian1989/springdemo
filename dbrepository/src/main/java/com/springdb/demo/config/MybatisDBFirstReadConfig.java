package com.springdb.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author zhangjunshuai
 * @date 2019/10/16
 * @description
 **/
@Configuration
@MapperScan(basePackages = {"com.springdb.demo.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory1")

public class MybatisDBFirstReadConfig {
    @Autowired
    @Qualifier("primaryDataSourceRead")
    private DataSource ds1;


    @Bean
    public SqlSessionFactory sqlSessionFactory1Read() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        // 使用primaryDataSource数据源, 连接primaryDataSource库
        factoryBean.setDataSource(ds1);

        return factoryBean.getObject();

    }
    @Bean
    public SqlSessionTemplate sqlSessionTemplate1Read() throws Exception {
        // 使用上面配置的Factory
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory1Read());
        return template;
    }
    @Bean(name = "dataSourceTransactionManagerFirstRead")
    public PlatformTransactionManager dataSourceTransactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(ds1);
        return dataSourceTransactionManager;
    }
}
