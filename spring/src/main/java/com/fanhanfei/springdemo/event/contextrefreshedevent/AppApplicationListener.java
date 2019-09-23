package com.fanhanfei.springdemo.event.contextrefreshedevent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.*;

/**
 * @author zhangjunshuai
 * @date 2019/7/23
 * @description
 * 实现ApplicationListener 和 @EventListener二者选其一即可
 **/
@Slf4j
public class AppApplicationListener implements ApplicationListener {

//    @EventListener
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextStartedEvent){
            log.info("================:{}", "ContextStartedEvent");
        }
        if (event instanceof ContextRefreshedEvent){
            log.info("================:{}", "ContextRefreshedEvent");
        }
        if (event instanceof ContextClosedEvent){
            log.info("================:{}", "ContextClosedEvent");
        }
        if (event instanceof ContextStoppedEvent){
            log.info("================:{}", "ContextStoppedEvent");
        }
        if (event instanceof ApplicationReadyEvent){
            log.info("================:{}", "ApplicationReadyEvent");
        }
        log.info(">>>>>>>>>>>>>>>>:{}\n", event.getClass().getName());
    }

}
