package com.fanhanfei.springweb.model.base;

/**
 * @author zhangjunshuai
 * @date 2020/2/18
 * @description
 **/
public interface ErrorCodeV2 extends ErrorCode {

    /**
     * 获取对应的http status
     * @return http状态码
     */
    int getHttpStatus();
}
