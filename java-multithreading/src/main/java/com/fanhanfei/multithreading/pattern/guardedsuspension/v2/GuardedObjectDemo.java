package com.fanhanfei.multithreading.pattern.guardedsuspension.v2;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * @author zhangjunshuai
 * @date 2020/6/29
 * @description
 **/
public class GuardedObjectDemo {
    public static void main(String[] args) {
        GuardedObject<GuardObj> guardObjGuardedObject = new GuardedObject<>();


        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 3,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(()->{
            GuardObj obj = guardObjGuardedObject.getObj(p -> Objects.nonNull(p) && p.getSize() > 0);
            System.out.println(obj);
        });

        //延时循环执行
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
//        延时3秒执行,每2秒执行一次
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            GuardObj guardObj = new GuardObj();
            guardObj.setSize(1);
            guardObj.setName("GuardTest");
            System.out.println("循环定时任务开始");
            guardObjGuardedObject.onchange(guardObj);
        }, 3, 2,TimeUnit.SECONDS);


//        scheduledExecutorService.shutdown();

        singleThreadPool.shutdown();



    }
}
