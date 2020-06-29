package com.fanhanfei.multithreading.pattern.guardedsuspension.v1;

import lombok.Data;
import lombok.ToString;

/**
 * @author zhangjunshuai
 * @date 2020/6/22
 * @description
 **/
@Data
@ToString
public class RequestMessage {
    private String id;
    private String context;
    private Long times = System.nanoTime();
}
