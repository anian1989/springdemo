package com.fanhanfei.javabeans.dynamic;

import lombok.experimental.var;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author zhangjunshuai
 * @date 2020/4/21
 * @description
 **/
public class Client {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ClassLoader classLoader = userService.getClass().getClassLoader();
        Class<?>[] interfaces = userService.getClass().getInterfaces();
        InvocationHandler logHandler = new LogHandler(userService);

        UserService instance = (UserService)Proxy.newProxyInstance(classLoader, interfaces, logHandler);
        System.out.println(instance);
        instance.select();

        instance.update();
    }
}
