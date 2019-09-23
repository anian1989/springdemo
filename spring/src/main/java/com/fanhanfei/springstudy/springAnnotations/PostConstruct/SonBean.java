package com.fanhanfei.springstudy.springAnnotations.PostConstruct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author zhangjunshuai
 * @date 2019/7/12
 * @description
 **/
@Component
@Slf4j
public class SonBean extends ParentBean {
    public SonBean() {
        log.info("SonBean construct");
    }

    @PostConstruct
    @Override
    public void init(){
        log.info("SonBean init");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("SonBean afterPropertiesSet");
    }
}
