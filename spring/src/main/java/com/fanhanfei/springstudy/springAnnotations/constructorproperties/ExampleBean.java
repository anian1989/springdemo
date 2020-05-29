package com.fanhanfei.springstudy.springAnnotations.constructorproperties;

import lombok.ToString;

import java.beans.ConstructorProperties;

/**
 * @author zhangjunshuai
 * @date 2020/5/29
 * @description
 **/
@ToString
public class ExampleBean {
    private int years;
    private String answer;

    /**
     *  ConstructorProperties 相当于给入参起了别名
     * @param years
     * @param answer
     */
    @ConstructorProperties({"yearAlias", "answerAlias"})
    public ExampleBean(int years, String answer) {
        this.years = years;
        this.answer = answer;
    }
}
