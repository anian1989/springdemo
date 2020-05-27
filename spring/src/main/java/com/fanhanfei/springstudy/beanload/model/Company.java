package com.fanhanfei.springstudy.beanload.model;

/**
 * @author zhangjunshuai
 * @date 2020/5/27
 * @description
 **/
public class Company {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
