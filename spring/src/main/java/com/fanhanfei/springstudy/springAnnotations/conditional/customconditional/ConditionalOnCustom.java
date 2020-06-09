package com.fanhanfei.springstudy.springAnnotations.conditional.customconditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * 自定义Conditional
 * @author zhangjunshuai
 * @date 2020/6/9
 * @description
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@Conditional(CustomConditionalProcessor.class)
public @interface ConditionalOnCustom {
    /**
     * 系统名称
     */
    String[] osnames() default {};

    /**
     * 忽略掉的配置
     * @return
     */
    String ignorePre() default "";
}
