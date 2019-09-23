package com.fanhanfei.springdemo.springAnnotations.PostConstruct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author zhangjunshuai
 * @date 2019/7/12
 * @description
 **/
@Component
@Slf4j
public class ParentBean implements InitializingBean {
    public ParentBean() {
        log.info("ParentBean construct");
    }

    @PostConstruct
    public void init(){
        log.info("ParentBean init");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("ParentBean afterPropertiesSet");
    }

}
