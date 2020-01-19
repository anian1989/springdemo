package com.fanhanfei.javabeans.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author zhangjunshuai
 * @date 2020/1/15
 * @description
 **/
public class BeanInfoUtil<T> {

    /**
     * @param object 实例
     * @param propertyName 属性名
     * @throws Exception
     */
    public static void setProperty(Object object, String propertyName) throws Exception {
        PropertyDescriptor propDesc = new PropertyDescriptor(propertyName, object.getClass());
        Method methodSetUserName = propDesc.getWriteMethod();
        Class<?>[] parameterTypes = methodSetUserName.getParameterTypes();
        Class<?> parameterType = parameterTypes[0];
        String simpleName = parameterType.getSimpleName();
        if (String.class.getSimpleName().equals(simpleName)){
            methodSetUserName.invoke(object, "三地方随碟附送");
        }
        if (Integer.class.equals(parameterType)){
            methodSetUserName.invoke(object, 100);
        }
    }

    /**
     * @param object 实例
     * @param propertyName 属性名
     * @throws Exception
     */
    public static void getProperty(Object object, String propertyName) throws Exception {
        PropertyDescriptor proDescriptor = new PropertyDescriptor(propertyName, object.getClass());
        Method methodGetUserName = proDescriptor.getReadMethod();
        Object objUserName = methodGetUserName.invoke(object);
        System.out.println("get userName:" + objUserName.toString());
    }

    /**
     * @param object 实例
     * @param propertyName 属性名
     * @throws Exception
     */
    public static void setPropertyByIntrospector(Object object, String propertyName) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(Object.class);
        PropertyDescriptor[] proDescrtptors = beanInfo.getPropertyDescriptors();
        if (proDescrtptors != null && proDescrtptors.length > 0) {
            for (PropertyDescriptor propDesc : proDescrtptors) {
                if (propDesc.getName().equals(propertyName)) {
                    Method methodSetUserName = propDesc.getWriteMethod();
                    methodSetUserName.invoke(object, "niocoder");
                    break;
                }
            }
        }
    }

    /**
     * @param object 实例
     * @param propertyName 属性名
     * @throws Exception
     */
    public static void getPropertyByIntrospector(Object object, String propertyName) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
        PropertyDescriptor[] proDescrtptors = beanInfo.getPropertyDescriptors();
        if (proDescrtptors != null && proDescrtptors.length > 0) {
            for (PropertyDescriptor propDesc : proDescrtptors) {
                if (propDesc.getName().equals(propertyName)) {
                    Method methodGetUserName = propDesc.getReadMethod();
                    Object objUserName = methodGetUserName.invoke(object);
                    System.out.println("get userName:" + objUserName.toString());
                    break;
                }
            }
        }
    }
}
