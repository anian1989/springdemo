package com.fanhanfei.multithreading;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjunshuai
 * @date 2020/4/12
 * @description JDK新增的异步编程工具
 **/
public class CompletableFutureObj {


    void sleep(int t, TimeUnit u) {
        try {
            u.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void apply(){

        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            Thread.currentThread().setName("f1");
            System.out.println(Thread.currentThread().getName()+"=T1 ： 洗水壶……");
            sleep(1, TimeUnit.SECONDS);

            System.out.println(Thread.currentThread().getName()+"=T1 ： 烧开水🔥……");
            sleep(15, TimeUnit.SECONDS);
        });

        CompletableFuture<List<String>> f1supply = CompletableFuture.supplyAsync(()->{
            return Lists.newArrayList("T1","Supply");
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
    /*CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf) -> {
        Thread.currentThread().setName("thenCombine");
        System.out.println(Thread.currentThread().getName()+"=T1:拿到茶叶:" + tf);
        System.out.println(Thread.currentThread().getName()+"=T1:泡茶...");
        return "上茶:" + tf;
    });*/

        CompletableFuture<String> f3 = f1supply.thenCombine(f2, (kk, tf) -> {
            Thread.currentThread().setName("thenCombine");
            System.out.println(kk.get(0));
            System.out.println(Thread.currentThread().getName()+"=T1:拿到茶叶:" + tf);
            System.out.println(Thread.currentThread().getName()+"=T1:泡茶...");
            return "上茶:" + tf;
        });

        System.out.println(f3.join());
    }


    public void thenApply(){
        CompletableFuture<String> f0 = CompletableFuture.supplyAsync(() ->"hello world")
                .thenApply(s -> s+" QQ")
                .thenApply(String::toUpperCase);
        System.out.println(f0.join());
    }

    public void or(){

        CompletableFuture<String> f1 =
                CompletableFuture.supplyAsync(()->{
                    int t = RandomUtils.nextInt(5, 10);
                    System.out.println("f1:"+t);
                    sleep(t, TimeUnit.SECONDS);
                    return String.valueOf(t);
                });

        CompletableFuture<String> f2 =
                CompletableFuture.supplyAsync(()->{
                    int t = RandomUtils.nextInt(50, 100);
                    System.out.println("f2:"+t);
                    sleep(t, TimeUnit.SECONDS);
                    return String.valueOf(t);
                });

        CompletableFuture<String> f3 =
                f2.applyToEither(f1,s -> s);

        System.out.println(f3.join());
    }
}
