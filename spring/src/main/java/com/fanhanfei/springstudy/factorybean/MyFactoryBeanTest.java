package com.fanhanfei.springstudy.factorybean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;

/**
 * @author zhangjunshuai
 * @date 2020/5/26
 * @description
 **/
public class MyFactoryBeanTest {

    /**
     * 测试验证FactoryBean原理，代理一个servcie在调用其方法的前后，打印日志亦可作其他处理
     * 从ApplicationContext中获取自定义的FactoryBean
     * context.getBean(String beanName) ---> 最终获取到的Object是FactoryBean.getObejct(),
     * 使用Proxy.newInstance生成service的代理类
     */
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        // # 实例化基于 Properties 资源 BeanDefinitionReader
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        String[] locations={"hello-beans.xml"};
        int i = xmlBeanDefinitionReader.loadBeanDefinitions(locations);

        System.out.println("已加载 BeanDefinition 数量："+i);

        HelloWorldService helloWorldService = (HelloWorldService)defaultListableBeanFactory.getBean("fbHelloWorldService");
        helloWorldService.getBeanName();
        helloWorldService.sayHello();




    }

}
