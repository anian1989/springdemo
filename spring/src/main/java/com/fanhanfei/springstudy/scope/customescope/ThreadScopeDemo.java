package com.fanhanfei.springstudy.scope.customescope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * @author zhangjunshuai
 * @date 2020/6/1
 * @description
 **/
public class ThreadScopeDemo {
    @Bean
    @Scope(ThreadScope.SCOPE_NAME)
    public ScopUser scopUser(){
        ScopUser scopUser = new ScopUser();
        scopUser.setAge(System.nanoTime());
        return scopUser;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ThreadScopeDemo.class);

        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.registerScope(ThreadScope.SCOPE_NAME, new ThreadScope());
        });

        applicationContext.refresh();

        scopedBeansByLookup(applicationContext);

        applicationContext.close();

    }

    private static void scopedBeansByLookup(AnnotationConfigApplicationContext applicationContext) {

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> {
                // user 是共享 Bean 对象
                ScopUser user = applicationContext.getBean("scopUser", ScopUser.class);
                System.out.printf("[Thread id :%d] user = %s%n", Thread.currentThread().getId(), user);
            });

            // 启动线程
            thread.start();
            // 强制线程执行完成
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void scopedBeansByInjection(AnnotationConfigApplicationContext applicationContext) {
    }
}
