package com.fanhanfei.springstudy.di.circular;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入的测试的测试
 * @author zhangjunshuai
 * @date 2020/5/29
 * @description
 **/
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        String[] locations = {"di/di-set.xml","di/di-construct.xml","di/di-factorymethod.xml"};
        classPathXmlApplicationContext.setConfigLocations(locations);
        classPathXmlApplicationContext.refresh();
        // # 通过Set的方式注入
        ExampleBean exampleBean = (ExampleBean)classPathXmlApplicationContext.getBean("exampleBean");
        System.out.println(exampleBean);

        // # 通过构造方法注入
        ExampleConstructBean exampleConstructBean = (ExampleConstructBean) classPathXmlApplicationContext.getBean("exampleConstructBean");
        System.out.println(exampleConstructBean);

        // # 通过工厂方法创建,注意入参的配置
        ExampleWithFactoryBean exampleWithFactoryBean = (ExampleWithFactoryBean)classPathXmlApplicationContext.getBean("exampleWithFactoryBean");
        System.out.println(exampleWithFactoryBean);
        classPathXmlApplicationContext.close();

    }
}
