package com.fanhanfei.springstudy.di.apt;

/**
 * @author zhangjunshuai
 * @date 2019/7/10
 * @description
 **/
@Factory(
        id = "Tiramisu",
        type = Meal.class
)
public class Tiramisu implements Meal {
    @Override
    public float getPrice() {
        return 4.5f;
    }
}
