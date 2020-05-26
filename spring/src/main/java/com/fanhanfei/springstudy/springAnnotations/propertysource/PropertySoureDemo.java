package com.fanhanfei.springstudy.springAnnotations.propertysource;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author zhangjunshuai
 * @date 2020/5/26
 * @description
 **/
//@Configuration
//@PropertySource(value = { "classpath:application.properties" })
@Component
@Data
public class PropertySoureDemo {
    @Value("${logging.level.com}")
    private String levelStr;
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(PropertySoureDemo.class);
        annotationConfigApplicationContext.register(AppConfig.class);
        annotationConfigApplicationContext.refresh();

        PropertySoureDemo propertySoureDemo = (PropertySoureDemo)annotationConfigApplicationContext.getBean("propertySoureDemo");
        System.out.println(propertySoureDemo.getLevelStr());

        annotationConfigApplicationContext.close();
    }
}
