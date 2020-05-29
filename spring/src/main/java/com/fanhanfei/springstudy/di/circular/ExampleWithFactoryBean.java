package com.fanhanfei.springstudy.di.circular;

import lombok.Data;
import lombok.ToString;

/**
 * 通过工厂方法创建
 *
 * @author zhangjunshuai
 * @date 2020/5/29
 * @description
 **/
@ToString
@Data
public class ExampleWithFactoryBean {

    private AnotherBean beanOne;

    private YetAnotherBean beanTwo;

    private int i;

    private ExampleWithFactoryBean(){

    }

    // a static factory method; the arguments to this method can be
    // considered the dependencies of the bean that is returned,
    // regardless of how those arguments are actually used.
    public static ExampleWithFactoryBean createInstance(AnotherBean anotherBean, YetAnotherBean yetAnotherBean, int i) {

        ExampleWithFactoryBean eb = new ExampleWithFactoryBean();
        eb.setBeanOne(anotherBean);
        eb.setBeanTwo(yetAnotherBean);
        eb.setI(i);
        return eb;
    }
}
