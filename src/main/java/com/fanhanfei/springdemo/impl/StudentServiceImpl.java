package com.fanhanfei.springdemo.impl;

import com.fanhanfei.springdemo.service.HelloService;
import com.fanhanfei.springdemo.service.RountingInjected;
import com.fanhanfei.springdemo.service.StudentService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openjdk.jmh.annotations.Benchmark;
import org.springframework.stereotype.Service;

/**
 * @author zhangjunshuai
 * @date 2019/4/10
 * @description
 **/
@Data
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    private String config;
    private Integer age;
    @RountingInjected(value = "helloSer")
    private HelloService helloService;



    @Override
    public void testBeanFactoryPostProcessor() {
        helloService.sayHello();
        log.info("测试结果：{},{}",config,age);
    }
}
