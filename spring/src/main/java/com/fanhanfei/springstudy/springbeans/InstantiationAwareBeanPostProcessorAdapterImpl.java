package com.fanhanfei.springstudy.springbeans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * @author zhangjunshuai
 * @date 2019/7/22
 * @description
 **/
@Component
@Slf4j
public class InstantiationAwareBeanPostProcessorAdapterImpl extends InstantiationAwareBeanPostProcessorAdapter {
    public InstantiationAwareBeanPostProcessorAdapterImpl() {
        super();
        log.info("【容器级接口】【InstantiationAwareBeanPostProcessorAdapter实现类】【构造器】");
    }

    // 实例化Bean之前调用
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        log.info("【容器级接口】【InstantiationAwareBeanPostProcessor实现类】实例化Bean之前调用");
        return null;
    }

    // 实例化Bean之后调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        log.info("【容器级接口】【InstantiationAwareBeanPostProcessor实现类】实例化Bean之后调用");
        return true;
    }

    // 初始化Bean之前调用
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("【容器级接口】【InstantiationAwareBeanPostProcessor实现类】初始化Bean之前调用");
        return bean;
    }

    // 初始化Bean之后调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("【容器级接口】【InstantiationAwareBeanPostProcessor实现类】初始化Bean之后调用");
        return bean;
    }

    // 设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
                                                    String beanName) throws BeansException {
        log.info("【容器级接口】【InstantiationAwareBeanPostProcessor实现类】实例化Bean之后，设置某个属性时调用");
        return pvs;
    }
}

