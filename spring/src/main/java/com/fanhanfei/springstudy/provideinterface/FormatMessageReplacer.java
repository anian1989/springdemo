package com.fanhanfei.springstudy.provideinterface;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zhangjunshuai
 * @date 2020/6/1
 * @description
 **/
@Component("replacementTarget")
public class FormatMessageReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object target, Method method, Object[] args)  throws Throwable {

        if (isFormatMessageMethod(method)) {

            String msg = (String) args[0];

            return "替换数据" + msg + "</h2>";
        } else {
            throw new IllegalArgumentException("Unable to reimplement method "
                    + method.getName());
        }
    }

    private boolean isFormatMessageMethod(Method method) {

        // check correct number of params
        if (method.getParameterTypes().length != 1) {
            return false;
        }

        // check method name
        if (!("formatMessage".equals(method.getName()))) {
            return false;
        }

        // check return type
        if (method.getReturnType() != String.class) {
            return false;
        }

        // check parameter type is correct
        if (method.getParameterTypes()[0] != String.class) {
            return false;
        }

        return true;
    }

}
