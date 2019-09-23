package com.fanhanfei.springstudy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjunshuai
 * @date 2019/6/20
 * @description 练习Java 8 Map的新方法
 **/
public class Java8Map {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(5, null);
        //如果指定的key存在，则返回该key对应的value，如果不存在，则返回指定的值,但是如果存放的值是null会返回null
        System.out.println(map.getOrDefault(6,"KKK"));
        //如果key关联的value不存在，则关联新的value值，返回key关联的旧的值
        //map.get(key) = null 那么 map.put(key,newValue)
        map.putIfAbsent(3, "d");
        map.putIfAbsent(4, "4d");
        System.out.println(map.get(3));
        System.out.println(map.get(4));

        //remove(key,value) 如果key关联的value值与指定的value值相等（equals)，则删除这个元素
        map.remove(1, "b");
        // 未删除成功， 输出 a
        System.out.println(map.get(1));
        map.remove(2, "b");
        // 删除成功，输出 null
        System.out.println(map.get(2));

        //replace(K key, V oldValue, V newValue) 方法
        //如果key关联的值与指定的oldValue的值相等，则替换成新的newValue




        //replace(K key, V value) 方法
        //如果map中存在key，则替换成value值，否则返回null

        //computeIfAbsent 方法
        ///如果指定的key不存在，则通过指定的K -> V计算出新的值设置为key的值
        map.computeIfAbsent(41, key -> key + ":computed");
        // 不存在key为4，则进行计算，输出值 41:computed
        System.out.println(map.get(41));

        //computeIfPresent 方法
        //如果指定的key存在，则根据旧的key和value计算新的值newValue, 如果newValue不为null，则设置key新的值为newValue, 如果newValue为null, 则删除该key的值
        map.computeIfPresent(1, (key, value) -> (key + 1) + value);
        // 存在key为1， 则根据旧的key和value计算新的值，输出 2a
        System.out.println(map.get(1));





    }
}
