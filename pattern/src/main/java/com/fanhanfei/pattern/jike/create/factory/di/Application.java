package com.fanhanfei.pattern.jike.create.factory.di;

/**
 * @author zhangjunshuai
 * @date 2020/3/19
 * @description
 **/
public interface Application {
    Object getBean(String beanId);
}
