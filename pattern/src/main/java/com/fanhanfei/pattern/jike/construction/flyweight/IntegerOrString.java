package com.fanhanfei.pattern.jike.construction.flyweight;

/**
 * @author zhangjunshuai
 * @date 2020/3/31
 * @description
 * 增加配置 -Djava.lang.Integer.IntegerCache.high=256 之后再测试一下结果
 **/
public class IntegerOrString {
    public static void main(String[] args) {
        Integer i = 56;
        Integer j = Integer.valueOf(56);
        Integer h = 156;
        Integer k = 156;
        System.out.println(j == i);
        System.out.println(h == k);

        String a = "a";
        String b = "a";
        String c = new String("a");
        String c1 = String.valueOf("a");


        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(c1 == c);

    }
}
