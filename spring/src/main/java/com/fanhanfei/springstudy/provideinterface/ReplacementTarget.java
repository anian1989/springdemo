package com.fanhanfei.springstudy.provideinterface;

import org.springframework.stereotype.Component;

/**
 * @author zhangjunshuai
 * @date 2020/6/1
 * @description
 **/
@Component("standardTarget")
public class ReplacementTarget {
    public String formatMessage(String msg) {
        return "原数据" + msg ;
    }

    public String formatMessage(Object msg) {
        return "原数据" + msg ;
    }

    public void foo() {

    }
}
