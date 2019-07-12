package com.fanhanfei.springdemo;

import com.fanhanfei.springdemo.springAnnotations.PostConstruct.SonBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author zhangjunshuai
 * @date 2019/7/12
 * @description
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PostConstructTest {
    @Resource
    SonBean sonBean;
    @Test
    public void test(){
        log.info("==================");
    }
}
