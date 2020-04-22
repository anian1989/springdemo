package com.fanhanfei.javabeans.dynamic.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * @author zhangjunshuai
 * @date 2020/4/21
 * @description
 **/
public class Client {
    public static void main(String[] args) {
        LogInerceptor logInerceptor = new LogInerceptor();
        LogInterceptor2 logInterceptor2 = new LogInterceptor2();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallbacks(new Callback[]{logInerceptor,logInterceptor2,NoOp.INSTANCE});
        enhancer.setCallbackFilter(new DaoFilter());

        UserDao o = (UserDao)enhancer.create();
        o.select();
        o.update();
    }
}
