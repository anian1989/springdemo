package com.fanhanfei.springdemo.proxy;

/**
 * 需要动态代理的接口
 */
public interface SubjectService {

    String SayHello(String name);

    String SayGoodBye();
}
