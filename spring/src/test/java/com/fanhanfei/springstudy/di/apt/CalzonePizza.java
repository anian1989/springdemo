package com.fanhanfei.springstudy.di.apt;

/**
 * @author zhangjunshuai
 * @date 2019/7/10
 * @description
 **/
@Factory(
        id = "Calzone",
        type = Meal.class
)
public class CalzonePizza implements Meal {
    @Override
    public float getPrice() {
        return 8.5f;
    }
}
