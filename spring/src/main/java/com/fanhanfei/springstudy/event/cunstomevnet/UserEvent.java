package com.fanhanfei.springstudy.event.cunstomevnet;


import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * @author zhangjunshuai
 * @date 2020/6/11
 * @description
 **/
@ToString(callSuper = true)
public class UserEvent extends ApplicationEvent {

    private String name;
    private Integer age;


    public UserEvent(Object source, String name, Integer age) {
        super(source);
        this.name = name;
        this.age = age;
    }
}
