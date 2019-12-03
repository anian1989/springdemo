package com.fanhanfei.guava;

import com.google.common.base.MoreObjects;
import com.google.common.collect.FluentIterable;

/**
 * @author zhangjunshuai
 * @date 2019/11/29
 * @description
 **/
public class MoreObjectsMy {

    public static void main(String[] args) {
        Integer integer = MoreObjects.firstNonNull(null, 2);
        System.out.println(integer);
        Integer kk = 4;
        MoreObjects.ToStringHelper toStringHelper = MoreObjects.toStringHelper(kk);
        System.out.println(toStringHelper.add("t",3).toString());
    }
}
