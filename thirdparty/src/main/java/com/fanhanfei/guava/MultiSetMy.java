package com.fanhanfei.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;

import java.util.Set;

/**
 * @author zhangjunshuai
 * @date 2019/11/29
 * @description
 **/
public class MultiSetMy {
    public static void main(String[] args) {
        HashMultiset<String> hashMultiset = HashMultiset.create(Lists.newArrayList("0","1","2","3","4"));
        hashMultiset.add("0");
        hashMultiset.add("1");
        hashMultiset.add("1");

        //判断某个在不在
        System.out.println(hashMultiset.contains("0"));
        System.out.println(hashMultiset.contains("1"));
        System.out.println(hashMultiset.contains("2"));
        System.out.println(hashMultiset.contains("3"));
        System.out.println(hashMultiset.contains("4"));
        System.out.println(hashMultiset.contains("5"));

        System.out.println("===============================");

        //统计某个值出现的次数
        System.out.println(hashMultiset.count("0"));
        System.out.println(hashMultiset.count("1"));
        System.out.println(hashMultiset.count("2"));
        System.out.println(hashMultiset.count("3"));
        System.out.println(hashMultiset.count("4"));
        System.out.println(hashMultiset.count("5"));

        System.out.println("===============================");

        //循环输出
        hashMultiset.forEach(System.out::print);

        System.out.println();
        System.out.println("===============================");

        //让"4"，在集合中出现4次。原本就一个4，现在设置之后，就变成4个4了。
        hashMultiset.setCount("4", 4);

        //循环输出，看结果
        hashMultiset.forEach(System.out::print);

        System.out.println();
        System.out.println("===============================");

        //得到所有的去重的结果。
        Set<String> set = hashMultiset.elementSet();
        set.forEach(System.out::print);

        System.out.println();


    }
}
