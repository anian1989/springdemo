package com.fanhanfei.springstudy.factorybean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author zhangjunshuai
 * @date 2020/5/26
 * @description
 **/
@Configuration
public class MyFactoryBeanConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public MyFactoryBean factoryBean(){

        return new MyFactoryBean();
    }
}
