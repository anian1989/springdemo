package com.fanhanfei.springstudy.di.circular;

import lombok.ToString;

/**
 * @author zhangjunshuai
 * @date 2020/5/29
 * @description
 **/
@ToString
public class ExampleConstructBean {

    private AnotherBean beanOne;

    private YetAnotherBean beanTwo;

    private int i;

    public ExampleConstructBean(AnotherBean beanOne, YetAnotherBean beanTwo, int i) {
        this.beanOne = beanOne;
        this.beanTwo = beanTwo;
        this.i = i;
    }
}
