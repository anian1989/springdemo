package com.fanhanfei.multithreading;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

/**
 * @author zhangjunshuai
 * @date 2020/4/1
 * @description
 **/
public class StampedLockObj {

    public static void first() throws InterruptedException {
        final StampedLock lock = new StampedLock();
        Thread T1 = new Thread(() -> {
            // 获取写锁
            lock.writeLock();
            // 永远阻塞在此处，不释放写锁
            LockSupport.park();
        });
        T1.start();
        // 保证T1获取写锁
        Thread.sleep(100);
        Thread T2 = new Thread(() ->
                //阻塞在悲观读锁
                lock.readLock()
        );
        T2.start();
        // 保证T2阻塞在读锁
        Thread.sleep(100);
        //中断线程T2
        //会导致线程T2所在CPU飙升
        T2.interrupt();
        T2.join();
    }

    static final StampedLock SL = new StampedLock();

    public static void readModle() {

        // 乐观读
        long stamp = SL.tryOptimisticRead();
        // 读入方法局部变量
        //......
        // 校验stamp
        if (!SL.validate(stamp)) {
            // 升级为悲观读锁
            stamp = SL.readLock();
            try {
                // 读入方法局部变量
                //    .....
            } finally {
                //释放悲观读锁
                SL.unlockRead(stamp);
            }
        }
        //使用方法局部变量执行业务操作
        //......
    }

    public static void writeModle() {

        long stamp = SL.writeLock();
        try {
            // 写共享变量
//  ......
        } finally {
            SL.unlockWrite(stamp);
        }
    }
}
