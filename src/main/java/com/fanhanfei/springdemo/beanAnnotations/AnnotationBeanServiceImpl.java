package com.fanhanfei.springdemo.beanAnnotations;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjunshuai
 * @date 2019/7/24
 * @description
 **/
@Slf4j
public class AnnotationBeanServiceImpl implements AnnotationBeanService {
    @Override
    public void printMessage() {
        log.info("通过 @Bean 此注解和@Configuration 让Spring管理对象");
    }
}
