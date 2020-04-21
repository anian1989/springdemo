package com.fanhanfei.javabeans.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author zhangjunshuai
 * @date 2020/4/21
 * @description
 **/
public class LogHandler implements InvocationHandler {
    Object target;

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();

        Object invoke = method.invoke(target, args);
        after();
        return invoke;
    }

    private void before(){
        System.out.println(String.format("log start time[%s]",new Date()));
    }


    private void after(){
        System.out.println(String.format("log end time[%s]",new Date()));
    }
}
