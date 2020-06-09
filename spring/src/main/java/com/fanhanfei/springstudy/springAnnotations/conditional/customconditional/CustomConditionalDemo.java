package com.fanhanfei.springstudy.springAnnotations.conditional.customconditional;

import com.fanhanfei.springstudy.springAnnotations.conditional.OsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangjunshuai
 * @date 2020/6/9
 * @description
 **/
public class CustomConditionalDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(CustomConditionalConfig.class);
        applicationContext.refresh();

        OsService osService = (OsService)applicationContext.getBean("osService");
        System.out.println(osService);
        System.out.println(osService.getOsType());

        applicationContext.close();
    }
}
