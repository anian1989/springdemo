package com.fanhanfei.springstudy.factorybean;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangjunshuai
 * @date 2020/5/22
 * @description 代理一个类，拦截该类的所有方法，在方法的调用前后进行日志的输出
 **/
@Data
public class MyFactoryBean implements FactoryBean<Object>, InitializingBean, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(MyFactoryBean.class);
    private String interfaceName;
    private Object target;
    private Object proxyObj;
    @Override
    public void destroy() throws Exception {
        logger.debug("destroy......");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        proxyObj = Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[] { Class.forName(interfaceName) },
                (proxy, method, args) -> {
                    logger.debug("invoke method......" + method.getName());
                    logger.debug("invoke method before......" + System.currentTimeMillis());
                    Object result = method.invoke(target, args);
                    logger.debug("invoke method after......" + System.currentTimeMillis());
                    return result;            });
        logger.debug("afterPropertiesSet......");
    }

    @Override
    public Object getObject() throws Exception {
        logger.debug("getObject......");
        return proxyObj;
    }

    @Override
    public Class<?> getObjectType() {
        return proxyObj == null ? Object.class : proxyObj.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }



}
