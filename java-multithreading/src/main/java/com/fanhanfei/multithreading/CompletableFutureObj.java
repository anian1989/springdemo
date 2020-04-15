package com.fanhanfei.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjunshuai
 * @date 2020/4/12
 * @description JDK新增的异步编程工具
 **/
public class CompletableFutureObj {

    CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
        Thread.currentThread().setName("f1");
        System.out.println(Thread.currentThread().getName()+"=T1 ： 洗水壶……");
        sleep(1, TimeUnit.SECONDS);

        System.out.println(Thread.currentThread().getName()+"=T1 ： 烧开水🔥……");
        sleep(15, TimeUnit.SECONDS);
    });

    CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
        Thread.currentThread().setName("f2");
        System.out.println(Thread.currentThread().getName()+"=T2:洗茶壶...");
        sleep(1, TimeUnit.SECONDS);
        System.out.println(Thread.currentThread().getName()+"=T2:洗茶杯...");
        sleep(2, TimeUnit.SECONDS);
        System.out.println(Thread.currentThread().getName()+"=T2:拿茶叶...");
        sleep(1, TimeUnit.SECONDS);
        return "龙井";

    });

    /**
     * 表述“任务 3 要等待任务 1 和任务 2 都完成后才能开始”；
     */
    CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf) -> {
        Thread.currentThread().setName("thenCombine");
        System.out.println(Thread.currentThread().getName()+"=T1:拿到茶叶:" + tf);
        System.out.println(Thread.currentThread().getName()+"=T1:泡茶...");
        return "上茶:" + tf;
    });

    void sleep(int t, TimeUnit u) {
        try {
            u.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       /* CompletableFutureObj completableFutureObj = new CompletableFutureObj();
        System.out.println(completableFutureObj.f3.join());*/

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.schedule(() -> {
            System.out.println("test");
        },1,TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(() ->{
            System.out.println("test2");
        },1,2,TimeUnit.SECONDS);
    }
}
