package com.fanhanfei.springstudy.di.apt;

import javax.lang.model.element.Element;

/**
 * @author zhangjunshuai
 * @date 2019/7/10
 * @description
 **/
public class ProcessingException extends Exception {

    Element element;

    public ProcessingException(Element element, String msg, Object... args) {
        super(String.format(msg, args));
        this.element = element;
    }

    public Element getElement() {
        return element;
    }
}
