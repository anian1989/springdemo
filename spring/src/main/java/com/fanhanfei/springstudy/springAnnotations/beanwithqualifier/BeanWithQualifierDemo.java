package com.fanhanfei.springstudy.springAnnotations.beanwithqualifier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @author zhangjunshuai
 * @date 2020/6/7
 * @description
 **/
public class BeanWithQualifierDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(FactoryMethodComponent.class);
        applicationContext.refresh();

        Map<String, TestBean> beansOfType = applicationContext.getBeansOfType(TestBean.class);
        for (Map.Entry<String, TestBean> beanEntry : beansOfType.entrySet()) {
            System.out.println(beanEntry.getKey()+":"+beanEntry.getValue());
        }
        applicationContext.close();

    }
}
