package com.fanhanfei.pattern.jike.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangjunshuai
 * @date 2020/3/12
 * @description 单例-用静态内部类
 **/
public class InnerStaticSingle {
    private AtomicInteger integer = new AtomicInteger();

    private static class SingleHandler{
        private static final InnerStaticSingle instance = new InnerStaticSingle();
    }
    private InnerStaticSingle(){}

    public InnerStaticSingle getInstance(){
        return SingleHandler.instance;
    }

    private long getId(){
        return integer.incrementAndGet();
    }

}
