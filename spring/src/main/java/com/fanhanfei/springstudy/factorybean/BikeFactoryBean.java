package com.fanhanfei.springstudy.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author zhangjunshuai
 * @date 2020/5/22
 * @description
 **/
@Component
public class BikeFactoryBean implements FactoryBean<Bike> {
    @Override
    public Bike getObject() throws Exception {
        System.out.println("......开始创建Bike对象......");
        return new Bike();
    }

    @Override
    public Class<?> getObjectType() {
        return Bike.class;
    }

    /**
     * 设置为true 之后，同一个ApplicationContext里面只有一个对象
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
