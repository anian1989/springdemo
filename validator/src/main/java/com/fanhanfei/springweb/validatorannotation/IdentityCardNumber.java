package com.fanhanfei.springweb.validatorannotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author zhangjunshuai
 * @date 2020/2/23
 * @description 自定义校验注解
 **/
@Documented
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdentityCardNumberValidator.class)
public @interface IdentityCardNumber {
    String message() default "身份证号码不合法";

    /**
     * groups 这里主要进行将validator进行分类，不同的类group中会执行不同的validator操作
     * @return
     */
    Class<?>[] groups() default {};

    /**
     * payload 主要是针对bean的，使用不多。
     * @return
     */
    Class<? extends Payload>[] payload() default {};
}
