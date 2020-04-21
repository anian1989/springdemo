package com.fanhanfei.javabeans.introspector;


import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author zhangjunshuai
 * @date 2020/4/20
 * @description
 **/
public class ApacheBeanUtilsObj {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        try {
            BeanUtils.setProperty(userInfo,"name","zhangsan");
            System.out.println("set userName:"+userInfo.getName());

            System.out.println("get userName:"+BeanUtils.getProperty(userInfo, "name"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
