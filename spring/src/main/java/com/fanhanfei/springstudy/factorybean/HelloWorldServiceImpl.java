package com.fanhanfei.springstudy.factorybean;

import org.springframework.stereotype.Service;

/**
 * @author zhangjunshuai
 * @date 2020/5/26
 * @description
 **/
@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String getBeanName() {
        return "Hello Service Bean";
    }

    @Override
    public void sayHello() {
        System.out.println("say hello");
    }
}
