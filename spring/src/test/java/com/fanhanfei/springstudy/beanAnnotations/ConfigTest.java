package com.fanhanfei.springstudy.beanAnnotations;

import com.fanhanfei.springstudy.beanAnnotations.AnnotationBeanService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author zhangjunshuai
 * @date 2019/7/24
 * @description
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ConfigTest {
    @Resource
    AnnotationBeanService annotationBeanService;
    @Resource
    AnnotationBeanService annotationBeanServiceComponent;
    @Test
    public void testBean(){
        annotationBeanService.printMessage();
        annotationBeanServiceComponent.printMessage();



    }
}
