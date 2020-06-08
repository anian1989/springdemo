package com.fanhanfei.springstudy.profiles;

import com.fanhanfei.springstudy.lifecycle.initialization.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  ActiveProfile的配置有以下几种方式
 *  1、applicationContext.getEnvironment().setActiveProfiles("pre");
 *  2、-Dspring.profiles.active="profile1,profile2"
 *  3、@PropertySource
 *
 * @author zhangjunshuai
 * @date 2020/6/8
 * @description
 **/
public class ProfilesDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        applicationContext.getEnvironment().setActiveProfiles("pre");
        applicationContext.register(ProfilesConfigWithPropertySource.class);
        applicationContext.refresh();
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
    }
}
