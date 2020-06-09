package com.fanhanfei.springstudy.springAnnotations.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author zhangjunshuai
 * @date 2020/6/9
 * @description
 **/
public class LinuxServiceConditional implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().getProperty("os.name").equals("Linux");
    }
}
