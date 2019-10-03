package com.springdb.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author zhangjunshuai
 * @date 2019/10/2
 * @description
 **/
@Aspect
@Component
public class MDCAop {
    private static String MDC_KEY_REQ_ID = "reqId";

    @Pointcut("execution(public * com.springdb..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void before(JoinPoint joinPoint){
        MDC.put(MDC_KEY_REQ_ID, UUID.randomUUID().toString());
    }

    @AfterReturning(pointcut = "webLog()", returning = "ret")
    public void afterReturning(Object ret){
        MDC.remove(MDC_KEY_REQ_ID);
    }
}
