package com.fanhanfei.pattern.jike.create.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangjunshuai
 * @date 2020/3/12
 * @description 简单单例——饿汉模式
 **/
public class SimpleSingle {
    private AtomicInteger integer = new AtomicInteger();
    private static final SimpleSingle sim = new SimpleSingle();
    private SimpleSingle(){

    }

    public static SimpleSingle getInstance(){
        return sim;
    }

    public long getId(){
        return integer.incrementAndGet();
    }
}
