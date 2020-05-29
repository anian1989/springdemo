package com.fanhanfei.springstudy.di.apt;

import java.io.IOException;

/**
 * @author zhangjunshuai
 * @date 2019/7/10
 * @description
 **/
public class PizzaStore {
    public Meal order(String mealName) {

        if (mealName == null) {
            throw new IllegalArgumentException("Name of the meal is null!");
        }

        if ("Margherita".equals(mealName)) {
            return new MargheritaPizza();
        }

        if ("Calzone".equals(mealName)) {
            return new CalzonePizza();
        }

        if ("Tiramisu".equals(mealName)) {
            return new Tiramisu();
        }

        throw new IllegalArgumentException("Unknown meal '" + mealName + "'");
    }

    public static void main(String[] args) throws IOException {
        PizzaStore pizzaStore = new PizzaStore();
        Meal meal = pizzaStore.order("Margherita");
        System.out.println("Bill: $" + meal.getPrice());
    }
}
