package com.fanhanfei.multi;

import com.fanhanfei.multithreading.SemaphoreObjPool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author zhangjunshuai
 * @date 2020/3/30
 * @description
 **/
public class SemaphorePoolTest {

    @Test
    @DisplayName("测试📶")
    public void test() throws InterruptedException {

        // 创建对象池
        SemaphoreObjPool<Long, String> pool =
                new SemaphoreObjPool<>(10, 2L);
        // 通过对象池获取t，之后执行
        pool.exec(t -> {
            System.out.println(Thread.currentThread().getId() + ":" + t);
            return t.toString();
        });

    }
}
