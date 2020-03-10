package com.fanhanfei.springweb.validatorannotation;

import com.fanhanfei.springweb.common.validation.IdCardValidatorUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author zhangjunshuai
 * @date 2020/2/23
 * @description
 **/
public class IdentityCardNumberValidator implements ConstraintValidator<IdentityCardNumber, Object> {
    @Override
    public void initialize(IdentityCardNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("到达这里了");
        return IdCardValidatorUtils.isValidate18Idcard(o.toString());
    }
}
