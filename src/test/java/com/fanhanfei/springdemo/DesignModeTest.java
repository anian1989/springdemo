package com.fanhanfei.springdemo;

import com.fanhanfei.SpringdemoApplication;
import com.fanhanfei.designmode.HumanService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author zhangjunshuai
 * @date 2019/9/9
 * @description
 **/
@SpringBootTest(classes = SpringdemoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class DesignModeTest {

    @Resource
    HumanService humanServiceImplTwo;

    @Resource
    HumanService humanServiceImplOne;
    @Test
    public void testAbstract(){
        humanServiceImplOne.testAbstract();
        humanServiceImplTwo.testAbstract();
    }
}
