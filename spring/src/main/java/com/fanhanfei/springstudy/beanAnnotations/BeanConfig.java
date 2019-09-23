package com.fanhanfei.springstudy.beanAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangjunshuai
 * @date 2019/7/24
 * @description
 **/
@Configuration
public class BeanConfig {

    @Bean
    public AnnotationBeanService annotationBeanService(){
        return new AnnotationBeanServiceImpl();
    }
}
