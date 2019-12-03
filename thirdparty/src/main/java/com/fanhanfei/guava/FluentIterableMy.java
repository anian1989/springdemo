package com.fanhanfei.guava;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

import javax.annotation.Nullable;
import java.util.ArrayList;

/**
 * @author zhangjunshuai
 * @date 2019/11/29
 * @description
 **/
public class FluentIterableMy {
    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList("1", "2", "r");
        FluentIterable<String> cycle = FluentIterable.from(list)
                .transform((String kk) -> kk + "add")
                .filter(input -> !input.equals("r"))
                .limit(2)
                .append("6","7")
                .skip(1);
        String string = cycle.toString();
        System.out.println(string);
    }
}
