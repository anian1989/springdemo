package com.fanhanfei.multithreading.pattern.threadlocal;

import java.util.concurrent.atomic.AtomicLong;

import static java.lang.ThreadLocal.withInitial;

/**
 * @author zhangjunshuai
 * @date 2020/6/30
 * @description
 **/
public class ThreadLocalDemo {
    static final AtomicLong next = new AtomicLong(0);
    static final ThreadLocal<Long> localThread;

    static {
        localThread = withInitial(next::getAndIncrement);
    }

    static long get(){ return localThread.get(); }
}

