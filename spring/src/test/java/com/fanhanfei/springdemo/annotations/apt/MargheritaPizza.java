package com.fanhanfei.springdemo.annotations.apt;

/**
 * @author zhangjunshuai
 * @date 2019/7/10
 * @description
 **/
@Factory(
        id = "Margherita",
        type = Meal.class
)
public class MargheritaPizza implements Meal {
    @Override
    public float getPrice() {
        return 6.0f;
    }
}
