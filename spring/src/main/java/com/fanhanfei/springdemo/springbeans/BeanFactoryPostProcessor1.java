package com.fanhanfei.springdemo.springbeans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

import java.util.Iterator;

/**
 * @author zhangjunshuai
 * @date 2019/4/10
 * @description
 **/
@Slf4j
public class BeanFactoryPostProcessor1 implements BeanFactoryPostProcessor,Ordered {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("调用 BeanFactoryPostProcessor_1 ...");
        log.info("容器中有 BeanDefinition 的个数：" + beanFactory.getBeanDefinitionCount());
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
//            log.info("调用 BeanFactoryPostProcessor ："+beanDefinitionName);
        }

        Iterator<String> beanNamesIterator = beanFactory.getBeanNamesIterator();
       /* while (beanNamesIterator.hasNext()) {
            log.info("调用 BeanFactoryPostProcessor getBeanNamesIterator ："+beanNamesIterator.next());
        }*/

        // 获取指定的 BeanDefinition
        BeanDefinition bd = beanFactory.getBeanDefinition("studentService");
        MutablePropertyValues pvs = bd.getPropertyValues();
        pvs.addPropertyValue("config","Config配置");
        pvs.addPropertyValue("age",15);
    }
    @Override
    public int getOrder() {
        return 1;
    }

}
