package com.fanhanfei.spi;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2020/3/3
 * @description
 **/
public class MyServiveOtherImpl implements IMyServiceProvider {
    /**
     * spi的第一个方法
     *
     * @param param
     * @return
     */
    @Override
    public List<String> getAll(String param) {
        System.out.println(this.getClass().getName()+"输入的参数"+param);
        return Lists.newArrayList("wer","jhkjhk");
    }
}
