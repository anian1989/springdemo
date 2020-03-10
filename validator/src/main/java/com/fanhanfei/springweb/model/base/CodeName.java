package com.fanhanfei.springweb.model.base;

/**
 * @author zhangjunshuai
 * @date 2020/2/17
 * @description
 **/
public interface CodeName<T> {
    /**
     * 获取编号
     * @return  编号
     */
    T getCode();

    /**
     * 获取名称
     * @return  名称
     */
    String getName();
}