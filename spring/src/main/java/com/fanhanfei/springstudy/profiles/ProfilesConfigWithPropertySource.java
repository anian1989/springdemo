package com.fanhanfei.springstudy.profiles;

import com.fanhanfei.springstudy.lifecycle.initialization.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author zhangjunshuai
 * @date 2020/6/8
 * @description
 **/
@Configuration
@PropertySource("classpath:/profiles/app-profiles.properties")
public class ProfilesConfigWithPropertySource {
    @Autowired
    Environment env;

    @Bean
    @Profile("product")
    public User user(){
        User user = new User();
        user.setName(env.getProperty("spring.profiles.active"));
        return user;
    }

    @Bean("user")
    @Profile("pre|test")
    public User userTest(){
        User user = new User();
        user.setName("pre|test");
        return user;
    }

    @Bean("user")
    @Profile("default")
    public User userDefault(){
        User user = new User();
        user.setName("default");
        return user;
    }

}
