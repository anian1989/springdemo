package com.fanhanfei.springstudy.lifecycle.initialization;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

/**
 * @author zhangjunshuai
 * @date 2020/6/3
 * @description
 **/
public class BeanInitializationLifeCycleDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 添加 BeanPostProcessor 实现 MyInstantiationAwareBeanPostProcessor
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        // 添加 CommonAnnotationBeanPostProcessor 解决 @PostConstruct
        beanFactory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String[] locations = {"lifecycle/bean-constructor-dependency-injection.xml"};
        int beanNumbers = xmlBeanDefinitionReader.loadBeanDefinitions(locations);
        System.out.println("已加载 BeanDefinition 数量：" + beanNumbers);
        // 显示地执行 preInstantiateSingletons()
        // SmartInitializingSingleton 通常在 Spring ApplicationContext 场景使用
        // preInstantiateSingletons 将已注册的 BeanDefinition 初始化成 Spring Bean
        try {
            beanFactory.preInstantiateSingletons();
        } catch (BeansException e) {
            e.printStackTrace();
        }

        // 通过 Bean Id 和类型进行依赖查找
        /*User user = beanFactory.getBean("user", User.class);
        System.out.println(user);*/

        /*User superUser = beanFactory.getBean("superUser", User.class);
        System.out.println(superUser);*/

        UserHolder userHolder = beanFactory.getBean("userHolder", UserHolder.class);
        System.out.println(userHolder);

    }
}
