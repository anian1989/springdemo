package com.fanhanfei.springstudy.di;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    enum Color{ BULE,RED,GREEN};

    Color fruitColor() default Color.GREEN;
}
