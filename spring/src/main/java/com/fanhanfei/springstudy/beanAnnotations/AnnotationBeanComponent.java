package com.fanhanfei.springstudy.beanAnnotations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author zhangjunshuai
 * @date 2019/7/24
 * @description
 **/
@Component
@Slf4j
public class AnnotationBeanComponent {

    @Bean(name = {"annotationBeanServiceComponent"})
    public AnnotationBeanService annotationBeanService(){
        log.info(" @Bean注解支持@Configruation 也支持 @Component");
        return new AnnotationBeanServiceImpl();
    }
}
