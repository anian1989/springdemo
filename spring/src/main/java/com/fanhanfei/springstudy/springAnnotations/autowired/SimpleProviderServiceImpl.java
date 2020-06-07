package com.fanhanfei.springstudy.springAnnotations.autowired;

import org.springframework.stereotype.Component;

/**
 * @author zhangjunshuai
 * @date 2020/6/7
 * @description
 **/
@Component
public class SimpleProviderServiceImpl implements SimpleProviderService {
    @Override
    public void sayHello() {
        System.out.println("Autowired 通过set 的方式 自动查到到 这里");
    }
}
