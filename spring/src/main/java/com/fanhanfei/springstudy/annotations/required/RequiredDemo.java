package com.fanhanfei.springstudy.annotations.required;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  Required 注释应用于 bean 属性的 setter 方法，
 *  它表明受影响的 bean 属性在配置时必须放在 XML 配置文件中，
 *  否则容器就会抛出一个 BeanInitializationException 异常。
 * @author zhangjunshuai
 * @date 2020/5/29
 * @description
 **/
public class RequiredDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("required-bean.xml");
        Student student = (Student) classPathXmlApplicationContext.getBean("student");
        System.out.println(student);


    }
}
