package com.fanhanfei.springdemo.impl;

import com.fanhanfei.springdemo.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhangjunshuai
 * @date 2019/5/30
 * @description
 **/
@Service
@Slf4j
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
       log.info("说话++++++++++++++++++++++");
    }
}
