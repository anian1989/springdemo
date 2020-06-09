package com.fanhanfei.springstudy.springAnnotations.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  初步使用 @Conditional
 *  -Dos.name=Mac
 * @author zhangjunshuai
 * @date 2020/6/9
 * @description
 **/
public class ConditionalDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ConditionalConfig.class);
        applicationContext.refresh();

        OsService osService = (OsService) applicationContext.getBean("osService");
        System.out.println(osService);
        System.out.println(osService.getOsType());

        applicationContext.close();
    }
}
