package com.fanhanfei.springstudy.springAnnotations.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangjunshuai
 * @date 2020/6/9
 * @description
 **/
@Configuration
public class ConditionalConfig {
    @Bean("osService")
    @Conditional(LinuxServiceConditional.class)
    public OsService linuxService(){
        return new LinuxServiceImpl();
    }
    @Bean("osService")
    @Conditional(MacServiceConditional.class)
    public OsService macService(){
        return new MacServiceImpl();
    }
}
