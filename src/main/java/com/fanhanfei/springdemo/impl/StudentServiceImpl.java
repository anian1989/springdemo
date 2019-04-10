package com.fanhanfei.springdemo.impl;

import com.fanhanfei.springdemo.service.StudentService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjunshuai
 * @date 2019/4/10
 * @description
 **/
@Data
@Slf4j
public class StudentServiceImpl implements StudentService {
    private String config;
    private Integer age;

    @Override
    public void testBeanFactoryPostProcessor() {
        log.info("测试结果：{},{}",config,age);
    }
}
