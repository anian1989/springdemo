package com.fanhanfei.spi;

import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2020/3/3
 * @description spi接口
 **/
public interface IMyServiceProvider {
    /**
     * spi的第一个方法
     * @param param
     * @return
     */
    List<String>  getAll(String param);
}
