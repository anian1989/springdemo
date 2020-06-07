package com.fanhanfei.springstudy.springAnnotations.autowired;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangjunshuai
 * @date 2020/6/7
 * @description
 **/
@Service
@ToString
public class SimpleCustomer {
    private SimpleProviderService simpleProviderService;

    @Autowired
    public void setSimpleProviderService(SimpleProviderService simpleProviderService) {
        this.simpleProviderService = simpleProviderService;
    }
}
