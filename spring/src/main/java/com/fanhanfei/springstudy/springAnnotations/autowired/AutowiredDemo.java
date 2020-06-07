package com.fanhanfei.springstudy.springAnnotations.autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangjunshuai
 * @date 2020/6/7
 * @description
 **/
public class AutowiredDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AutowiredConfigur.class);
        applicationContext.refresh();
        Object simpleCustomer = applicationContext.getBean("simpleCustomer");
        System.out.println(simpleCustomer);
    }
}
