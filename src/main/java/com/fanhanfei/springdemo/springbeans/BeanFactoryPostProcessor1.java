package com.fanhanfei.springdemo.springbeans;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

/**
 * @author zhangjunshuai
 * @date 2019/4/10
 * @description
 **/
public class BeanFactoryPostProcessor1 implements BeanFactoryPostProcessor,Ordered {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("调用 BeanFactoryPostProcessor_1 ...");
        System.out.println("容器中有 BeanDefinition 的个数：" + beanFactory.getBeanDefinitionCount());
        // 获取指定的 BeanDefinition
        BeanDefinition bd = beanFactory.getBeanDefinition("studentService");
        MutablePropertyValues pvs = bd.getPropertyValues();
        pvs.addPropertyValue("config","chenssy1");
        pvs.addPropertyValue("age",15);
    }
    @Override
    public int getOrder() {
        return 1;
    }

}
