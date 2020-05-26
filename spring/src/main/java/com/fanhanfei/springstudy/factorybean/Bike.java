package com.fanhanfei.springstudy.factorybean;

import lombok.Data;
import lombok.ToString;

/**
 * @author zhangjunshuai
 * @date 2020/5/22
 * @description
 **/
@Data
@ToString
public class Bike {
    private String id  = String.valueOf(System.nanoTime());
}
