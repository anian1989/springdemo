package com.fanhanfei.springstudy.springAnnotations.conditional.customconditional;

import com.fanhanfei.springstudy.springAnnotations.conditional.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangjunshuai
 * @date 2020/6/9
 * @description
 **/
@Configuration
@ConditionalOnCustom(ignorePre ="pre")
public class CustomConditionalConfig {
    @Bean("osService")
    @ConditionalOnCustom(osnames = {"Linux"})
    public OsService linuxService(){
        return new LinuxServiceImpl();
    }
    @Bean("osService")
    @ConditionalOnCustom(osnames = {"Mac"})
    public OsService macService(){
        return new MacServiceImpl();
    }
}
