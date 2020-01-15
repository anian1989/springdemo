package com.fanhanfei.javabeans.introspector;

/**
 * @author zhangjunshuai
 * @date 2020/1/15
 * @description
 **/
public class BeanInfoTest {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("merryyou");
        try {
            BeanInfoUtil.getProperty(userInfo, "name");

            BeanInfoUtil.setProperty(userInfo, "name");

            BeanInfoUtil.getProperty(userInfo, "name");

            BeanInfoUtil.setPropertyByIntrospector(userInfo, "name");

            BeanInfoUtil.getPropertyByIntrospector(userInfo, "name");

            BeanInfoUtil.setProperty(userInfo, "age");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
