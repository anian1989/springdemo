package com.fanhanfei.springdemo.proxy.cglib;

/**
 * @author zhangjunshuai
 * @date 2019/6/27
 * @description
 **/
public class Mytest {

    public static void main(String[] args) {
        ProxyCglib proxyCglib = new ProxyCglib();
        HelloCglib proxy = (HelloCglib)proxyCglib.getProxy(HelloCglib.class);
        proxy.cglibHello();
    }
}
