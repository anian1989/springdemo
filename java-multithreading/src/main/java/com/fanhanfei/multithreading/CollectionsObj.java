package com.fanhanfei.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2020/4/2
 * @description
 * Collections的学习
 **/
public class CollectionsObj {
    public static void main(String[] args) {
        /**
         * 思考：
         * 装饰器模式
         * RandomAccess 标记接口
         */
        List<Object> objects = Collections.synchronizedList(new ArrayList<>());
        System.out.println(objects.getClass().getName());
    }


}
