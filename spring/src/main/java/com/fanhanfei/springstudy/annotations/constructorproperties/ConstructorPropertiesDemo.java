package com.fanhanfei.springstudy.annotations.constructorproperties;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author zhangjunshuai
 * @date 2020/5/29
 * @description
 **/
public class ConstructorPropertiesDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        String[] locations ={"constructor-properties.xml"};
        int i = xmlBeanDefinitionReader.loadBeanDefinitions(locations);
        System.out.println("已加载 BeanDefinition 数量："+i);

        ExampleBean bean = defaultListableBeanFactory.getBean(ExampleBean.class);
        System.out.println(bean);

    }
}
