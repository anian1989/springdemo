package com.fanhanfei.springstudy.profiles;

import com.fanhanfei.springstudy.lifecycle.initialization.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author zhangjunshuai
 * @date 2020/6/8
 * @description
 **/
@Configuration
public class ProfilesConfig {
    @Bean
    @Profile("product")
    public User user(){
        User user = new User();
        user.setName("正式环境");
        return user;
    }
    @Bean("user")
    @Profile("pre|test")
    public User userTest(){
        User user = new User();
        user.setName("pre|test");
        return user;
    }
}
