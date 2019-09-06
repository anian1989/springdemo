package com.fanhanfei.springdemo.proxy.cglib;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import net.sf.json.util.JSONUtils;

import java.util.ArrayList;

/**
 * @author zhangjunshuai
 * @date 2019/6/27
 * @description
 **/
public class Mytest {

    public static void main(String[] args) {
        /*ProxyCglib proxyCglib = new ProxyCglib();
        HelloCglib proxy = (HelloCglib)proxyCglib.getProxy(HelloCglib.class);
        proxy.cglibHello();*/


        Joiner joiner = Joiner.on("").skipNulls();
        String join = joiner.join(null, null, "-", "TTT");
        String s = join.replaceAll(" ", "");
        System.out.println(s);

        Iterable<String> split = Splitter.on("-").split(s);
        ArrayList<String> strings = Lists.newArrayList(Splitter.on("-").split(s));
        System.out.println(JSONObject.toJSONString(strings));

        ArrayList<Object> objects = Lists.newArrayList(s.split("-"));
        System.out.println("结果："+objects.get(0));


    }
}
