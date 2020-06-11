package com.fanhanfei.springstudy.event.cunstomevnet;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Service;

/**
 * @author zhangjunshuai
 * @date 2020/6/11
 * @description
 *
 **/
@Service
public class UserEventListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationContextEvent) {
            System.out.println("ApplicationContextEvent 的子集："+event);
            return;
        }
        System.out.println(event);

    }
}
