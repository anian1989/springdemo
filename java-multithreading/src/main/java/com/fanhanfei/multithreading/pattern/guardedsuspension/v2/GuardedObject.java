package com.fanhanfei.multithreading.pattern.guardedsuspension.v2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * @author zhangjunshuai
 * @date 2020/6/29
 * @description
 **/
public class GuardedObject<T> {
    T obj;
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();
    final int timeout = 1;

    public T getObj(Predicate<T> predicate) {
        lock.lock();
        try {
            while (!predicate.test(obj)) {
                System.out.println("开始等待");
                condition.await(timeout, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return obj;
    }

    public void onchange(T obj){
        lock.lock();
        try {
            this.obj = obj;
            System.out.println("开始通知");
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }


}
