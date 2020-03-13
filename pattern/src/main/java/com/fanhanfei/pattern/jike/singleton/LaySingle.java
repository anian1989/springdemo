package com.fanhanfei.pattern.jike.singleton;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangjunshuai
 * @date 2020/3/12
 * @description 单例——懒汉模式
 **/
public class LaySingle {
    private AtomicInteger integer = new AtomicInteger();
    private static volatile LaySingle laySingle = null;
    private LaySingle(){

    }
    public static LaySingle getInstance(){
        if (Objects.isNull(laySingle)){
            synchronized (LaySingle.class){
                if (Objects.isNull(laySingle)){
                    return laySingle = new LaySingle();
                }
            }
        }
        return laySingle;
    }

    public long getId(){
        return integer.incrementAndGet();
    }
}
