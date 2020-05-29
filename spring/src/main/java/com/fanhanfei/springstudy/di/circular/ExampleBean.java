package com.fanhanfei.springstudy.di.circular;

import lombok.ToString;

/**
 * @author zhangjunshuai
 * @date 2020/5/29
 * @description
 **/
@ToString
public class ExampleBean {

    private AnotherBean beanOne;

    private YetAnotherBean beanTwo;

    private int i;

    public void setBeanOne(AnotherBean beanOne) {
        this.beanOne = beanOne;
    }

    public void setBeanTwo(YetAnotherBean beanTwo) {
        this.beanTwo = beanTwo;
    }

    public void setIntegerProperty(int i) {
        this.i = i;
    }
}
