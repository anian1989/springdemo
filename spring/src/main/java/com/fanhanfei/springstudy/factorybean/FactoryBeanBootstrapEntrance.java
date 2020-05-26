package com.fanhanfei.springstudy.factorybean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

/**
 * @author zhangjunshuai
 * @date 2020/5/22
 * @description
 **/
@ComponentScan("com.fanhanfei.springstudy.factorybean")
public class FactoryBeanBootstrapEntrance {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(FactoryBeanBootstrapEntrance.class);
        // # 获取FactoryBean 自己的名称
        String[] beanNamesForType = applicationContext.getBeanNamesForType(BikeFactoryBean.class);
        System.out.println("BikeFactoryBean names:" + Arrays.asList(beanNamesForType));
// # 获取Bike的 名称
        String[] bikeNames = applicationContext.getBeanNamesForType(Bike.class);
        System.out.println("Bike.class names:" + Arrays.asList(bikeNames));

        // # 通过FactoryBean 获取 Bike对象
        // # 通过线程测试 isSingleton

        for (int i = 0; i <10 ; i++) {
            new Thread(() -> {
                Object bikeFactoryBean = applicationContext.getBean("bikeFactoryBean");
                System.out.println(bikeFactoryBean);
            }).start();

        }
        // # 通过Bike.class 获取对象
        Bike bean = applicationContext.getBean(Bike.class);
        System.out.println("通过Bike.class "+bean);

        Object bikeFactoryBean = applicationContext.getBean(BeanFactory.FACTORY_BEAN_PREFIX + "bikeFactoryBean");
        System.out.println("通过name 获取FactoryBean "+bikeFactoryBean);


        applicationContext.close();

    }
}
