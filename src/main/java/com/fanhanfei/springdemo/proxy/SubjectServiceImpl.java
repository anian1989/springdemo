package com.fanhanfei.springdemo.proxy;


/**
 * @author zhangjunshuai
 * @date 2019/6/20
 * @description
 **/
public class SubjectServiceImpl implements SubjectService {
    @Override
    public String SayHello(String name) {
        return name+":SayHello";
    }

    @Override
    public String SayGoodBye() {
        return "GOOD BYE";
    }
}
