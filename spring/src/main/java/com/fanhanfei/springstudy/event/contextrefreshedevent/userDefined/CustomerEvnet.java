package com.fanhanfei.springstudy.event.contextrefreshedevent.userDefined;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author zhangjunshuai
 * @date 2019/7/23
 * @description 被观察者
 **/
public class CustomerEvnet extends ApplicationEvent {
    @Getter
    private String name;

    public CustomerEvnet(Object source, String name) {
        super(source);
        this.name = name;
    }
}
