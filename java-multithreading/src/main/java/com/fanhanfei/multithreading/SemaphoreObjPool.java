package com.fanhanfei.multithreading;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * @author zhangjunshuai
 * @date 2020/3/27
 * @description 信号量
 **/
public class SemaphoreObjPool<T, R> {
    final List<T> pool;
    /**
     * 用信号量实现限流器
     */
    final Semaphore sem;

    /**
     * 构造函数
     *
     * @param size
     * @param t
     */
    public SemaphoreObjPool(int size, T t) {
        pool = new Vector<T>() {
        };
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        sem = new Semaphore(size);
    }

    /**
     * 利用对象池的对象，调用func
     *
     * @param func
     * @return
     * @throws InterruptedException
     */
    public R exec(Function<T, R> func) throws InterruptedException {
        T t = null;
        sem.acquire();
        try {
            t = pool.remove(0);

            return func.apply(t);
        } finally {
            pool.add(t);
            sem.release();
        }
    }
}

