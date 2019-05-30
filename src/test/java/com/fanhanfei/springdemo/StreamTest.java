package com.fanhanfei.springdemo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author zhangjunshuai
 * @date 2019/4/26
 * @description
 **/
@Slf4j
public class StreamTest {
    @Test
    public void testSum(){
        ArrayList<Student> objects = Lists.newArrayList();
        for (int i = 1; i < 10; i++) {
            Student student = new Student();
            student.setName(i+"");
            if (i%11==0){
                student.setAge(new Double(i));
            }
            objects.add(student);
        }
        log.info("测试：{}", JSON.toJSONString(objects));
        double sum = objects.stream().filter(kk -> Objects.nonNull(kk.getAge())).mapToDouble(Student::getAge).sum();
        log.info("结果:"+sum);

    }
}
@Data
class Student{
    private String name;
    private Double age;
}
