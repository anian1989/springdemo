package com.fanhanfei.common;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;
@Slf4j
public class BeanUtilsTest {

    @Test
    public void beanToMap() {
        HashMap<String, Object> objectObjectHashMap = Maps.newHashMap();
        objectObjectHashMap.put("code",1);
        objectObjectHashMap.put("name","zhangsan");
        Student student = new Student();
        Student student1 = BeanUtils.mapToBean(objectObjectHashMap, student);
        log.info("测试结果：{}",JSONObject.toJSONString(student1));

    }

    @Test
    public void mapToBean() {

    }
}