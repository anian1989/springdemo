package com.fanhanfei.javabeans.introspector.my;

import com.fanhanfei.javabeans.introspector.UserInfo;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author zhangjunshuai
 * @date 2020/4/20
 * @description
 **/
public class MyObj {

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("PP");
        userInfo.setAge(19);
        userInfo.setWebSite("1234567");
        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name",UserInfo.class);
            Method writeMethod = propertyDescriptor.getWriteMethod();
            writeMethod.invoke(userInfo, "KKK");
            Method readMethod = propertyDescriptor.getReadMethod();
            Object invoke = readMethod.invoke(userInfo);
            System.out.println(invoke);

            BeanInfo beanInfo = Introspector.getBeanInfo(UserInfo.class);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor descriptor : propertyDescriptors) {

                Method writeMethod1 = descriptor.getReadMethod();
                Object invoke1 = writeMethod1.invoke(userInfo);
                System.out.println(invoke1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
