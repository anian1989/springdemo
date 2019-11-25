package com.fanhanfei.common;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;

/**
 * @author zhangjunshuai
 * @date 2019/11/1
 * @description
 **/
@Slf4j
public class FluentIterableTest extends BaseTest{

    @Test
    public void testFilter() {
        ArrayList<Student> objects = Lists.newArrayList();
        Student student = new Student();
        student.setCode(4);
        student.setName("四");
        objects.add(student);

        Student student1 = new Student();
        student1.setCode(40);
        student1.setName("四shi");
        objects.add(student1);


        FluentIterable<Student> filter = FluentIterable.from(objects).filter(student22 -> student22.getCode() > 10);

        for (Student student2 : filter) {
            log.info("过滤结果："+JSONObject.toJSONString(student2));
        }

        FluentIterable<String> transform = FluentIterable.from(objects).transform(kk -> Joiner.on(",").join(kk.getCode(), kk.getName()));
        transform.forEach(tt-> log.info("拼接"+tt));

        Student studentap = new Student();
        studentap.setCode(50);
        studentap.setName("studentap四shi");

        FluentIterable<Student> append = FluentIterable.from(objects).append(studentap);
        BeanLogPrintUtil.printList(append.toList());
        Spliterator<Student> spliterator = FluentIterable.from(objects).cycle().spliterator();
        /*while (iterator.hasNext()) {
            log.info(JSONObject.toJSONString(iterator.next()));
        }*/

    }

}
