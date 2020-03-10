package com.fanhanfei.springweb.common;

import com.fanhanfei.springweb.model.base.ErrorCode;
import com.fanhanfei.springweb.model.base.ServiceException;
import com.fanhanfei.springweb.model.base.enums.BaseErrorCodeEnum;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author zhangjunshuai
 * @date 2020/2/23
 * @description 借鉴SpringValidatorAdapter
 **/
public class ValidatorDefault {
    private static ValidatorDefault validator;

    private static javax.validation.Validator javaxValidator;
    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        javaxValidator = factory.getValidator();
        validator = new ValidatorDefault();
    }

    private ValidatorDefault() {}

    /**
     * 获取验证器实例
     * @return
     */
    public static ValidatorDefault getInstance() {
       return validator;
    }

    /**
     * 验证实体，若验证不通过则抛出异常
     * @param entity    待验证的实体
     * @throws ServiceException
     */
    public void validate(Object entity) throws ServiceException {
        Set<ConstraintViolation<Object>> constraintViolations = javaxValidator.validate(entity);
        processConstraintViolations(constraintViolations, null);
    }

    /**
     * 验证实体，若验证不通过则抛出异常
     * @param entity    待验证的实体
     * @param groups    待验证的实体操作组
     * @throws ServiceException
     */
    public void validate(Object entity, Class<?>... groups)  throws ServiceException {
        Set<ConstraintViolation<Object>> constraintViolations = javaxValidator.validate(entity, groups);
        processConstraintViolations(constraintViolations, null);
    }

    /**
     * 验证实体，若验证不通过则抛出异常
     * @param entity    待验证的实体
     * @throws ServiceException
     */
    public void validateWithErrorCode(Object entity, ErrorCode errorCode) throws ServiceException {
        Set<ConstraintViolation<Object>> constraintViolations = javaxValidator.validate(entity);
        processConstraintViolations(constraintViolations, errorCode);
    }

    /**
     * 验证实体，若验证不通过则抛出异常
     * @param entity    待验证的实体
     * @param groups    待验证的实体操作组
     * @throws ServiceException
     */
    public void validateWithErrorCode(Object entity, ErrorCode errorCode, Class<?>... groups)  throws ServiceException {
        Set<ConstraintViolation<Object>> constraintViolations = javaxValidator.validate(entity, groups);
        processConstraintViolations(constraintViolations, errorCode);
    }

    private void processConstraintViolations(Set<ConstraintViolation<Object>> constraintViolations, ErrorCode errorCode) {
        if (constraintViolations == null || constraintViolations.size() == 0) {
            return;
        }
        StringBuilder msg = new StringBuilder();
        for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
            msg.append(",").append(constraintViolation.getMessage());
        }
        if (errorCode == null) {
            errorCode = BaseErrorCodeEnum.ILLEGAL_PARAMETER;
        }
        throw new ServiceException(errorCode.getCode(), msg.substring(1));
    }
}
