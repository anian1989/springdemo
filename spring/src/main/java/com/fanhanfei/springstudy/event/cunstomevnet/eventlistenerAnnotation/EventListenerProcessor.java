package com.fanhanfei.springstudy.event.cunstomevnet.eventlistenerAnnotation;

import com.fanhanfei.springstudy.event.cunstomevnet.UserEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.EventObject;

/**
 * @author zhangjunshuai
 * @date 2020/6/11
 * @description
 **/
@Component
public class EventListenerProcessor {
    @EventListener
    public void processUserEvent(UserEvent event){
        System.out.println("通过 @EventListener 获取："+event);
    }

    @EventListener({UserEvent.class,ContextRefreshedEvent.class})
    public void processMoreEvent(EventObject event){
        System.out.println("通过 @EventListener more 获取："+event.getClass());
    }

    @EventListener({UserEvent.class})
    @Async
    public void processMoreEventAsync(EventObject event){
        System.out.println("通过 异步 @EventListener more 获取："+event.getClass()+"     threadName:"+Thread.currentThread().getName());
    }
}
