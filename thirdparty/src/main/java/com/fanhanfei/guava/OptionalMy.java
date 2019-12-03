package com.fanhanfei.guava;

import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.base.Supplier;

import java.util.Set;

/**
 * @author zhangjunshuai
 * @date 2019/11/29
 * @description Optional的测试
 **/
public class OptionalMy {

    public static void main(String[] args) {
        String kk ="TT";
        Optional<String> of = Optional.fromNullable(kk).or(Optional.of("OrOf"));
        Set<String> strings = of.asSet();
        System.out.println(of.get());
        if (of.isPresent()) {
            System.out.println(2);
        }
        Optional<String> absent = Optional.absent();
        System.out.println(absent.hashCode());

        java.util.Optional<String> stringOptional = of.toJavaUtil();


//        MoreObjects.
    }
}
