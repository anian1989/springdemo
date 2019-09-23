package com.fanhanfei.springstudy.event.contextrefreshedevent.userDefined;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author zhangjunshuai
 * @date 2019/7/23
 * @description
 **/
@Slf4j
@Component
public class CustomEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;
    public void publish(){
        CustomerEvnet customerEvent = new CustomerEvnet(this,"click");
        publisher.publishEvent(customerEvent);
    }
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher=applicationEventPublisher;

    }
}
