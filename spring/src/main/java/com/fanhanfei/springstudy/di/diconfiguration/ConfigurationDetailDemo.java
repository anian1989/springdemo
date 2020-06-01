package com.fanhanfei.springstudy.di.diconfiguration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhangjunshuai
 * @date 2020/5/29
 * @description
 **/
public class ConfigurationDetailDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        String[] locations = {"di/di-collections.xml"};
        classPathXmlApplicationContext.setConfigLocations(locations);
        classPathXmlApplicationContext.refresh();
        // # 设置Collections 属性
        ComplexObject exampleBean = (ComplexObject)classPathXmlApplicationContext.getBean("moreComplexObject");
        System.out.println(exampleBean);

    }
}
