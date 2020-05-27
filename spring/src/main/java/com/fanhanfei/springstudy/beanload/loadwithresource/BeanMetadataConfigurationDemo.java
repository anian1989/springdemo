package com.fanhanfei.springstudy.beanload.loadwithresource;

import com.fanhanfei.springstudy.beanload.model.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;

/**
 * 通过property文件注入类
 * @author zhangjunshuai
 * @date 2020/5/27
 * @description 通过property文件注入类1
 **/
public class BeanMetadataConfigurationDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        // 实例化基于 Properties 资源 BeanDefinitionReader
        PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(defaultListableBeanFactory);

        String location = "user.properties";

        ClassPathResource classPathResource = new ClassPathResource(location);
//指定字符 UTF-8
        EncodedResource encodedResource = new EncodedResource(classPathResource, "UTF-8");
        int i = beanDefinitionReader.loadBeanDefinitions(encodedResource);

        System.out.println("已经加载 BeanDefinition 数量："+ i);

        User user = defaultListableBeanFactory.getBean("user", User.class);
        System.out.println(user);


    }
}
