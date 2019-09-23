package com.fanhanfei.springstudy;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

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

    @Test
    public void testList(){
        ArrayList<String> strings = Lists.newArrayList("kkk", "undefined", "TTT");
        log.info("测试：{}",JSON.toJSONString(strings));
        strings.removeIf(s-> s.equals("undefined"));
        log.info("测试：{}",JSON.toJSONString(strings));
    }

    @Test
    public void test(){
        String t1="";
    }

    @Test
    public void testUUID(){
        String s1 = UUID.randomUUID().toString().replaceAll("-", "");
        log.info("测试s1："+s1);
        Sets.SetView<Integer> difference = Sets.difference(Sets.newHashSet(1, 2, 3,7), Sets.newHashSet(1, 2, 3, 4, 5, 6));
        for (Integer integer : difference) {
            log.info("Sets diff测试："+integer);
        }

    }
}
@Data
class Student{
    private String name;
    private Double age;
}
