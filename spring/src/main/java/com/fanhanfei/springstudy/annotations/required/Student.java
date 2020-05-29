package com.fanhanfei.springstudy.annotations.required;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Required;

/**
 * @author zhangjunshuai
 * @date 2020/5/29
 * @description
 **/
@ToString
public class Student {
    private Integer age;
    private String name;
    private String sex;

    public Integer getAge() {
        return age;
    }

    @Required
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
