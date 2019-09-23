package com.fanhanfei.springstudy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author zhangjunshuai
 * @date 2019/6/20
 * @description
 **/
public class DynamicProxyDemonstration {

    public static void main(String[] args) {
        SubjectService subject =new  SubjectServiceImpl();
        InvocationHandler invocationHandler = new InvocationHandlerImpl(subject);

        Class<? extends SubjectService> aClass = subject.getClass();
        ClassLoader classLoader = aClass.getClassLoader();
        Class<?>[] interfaces = aClass.getInterfaces();
        SubjectService subjectService = (SubjectService) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        System.out.println("动态代理对象的类型："+subject.getClass().getName());

        String hello = subjectService.SayHello("jiankunking");
        System.out.println(hello);



    }
}
