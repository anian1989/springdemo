package com.fanhanfei.springstudy.event.cunstomevnet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangjunshuai
 * @date 2020/6/11
 * @description
 *  官方自带 Event 在
 * @see org.springframework.context.event
 **/
public class CustomEventDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.fanhanfei.springstudy.event");
        applicationContext.refresh();
        UserEvent userEvent = new UserEvent(CustomEventDemo.class, "张三", 18);
        UserEventPublisher userEventPublisher = (UserEventPublisher)applicationContext.getBean("userEventPublisher");
        userEventPublisher.sendEvent(userEvent);

        applicationContext.close();

    }
}
