package com.fanhanfei.springstudy.springAnnotations.beanwithqualifier;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author zhangjunshuai
 * @date 2020/6/7
 * @description
 **/
@Data
@ToString
@RequiredArgsConstructor
public class TestBean {

    private Integer age;
    private String name;
    private String country;
    /**
     * 配偶
     */
    private TestBean spouse;

    public TestBean( String name,Integer age) {
        this.age = age;
        this.name = name;
    }

    public TestBean(String name) {
        this.name = name;
    }
}
