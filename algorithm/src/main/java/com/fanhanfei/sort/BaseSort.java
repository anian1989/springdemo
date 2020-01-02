package com.fanhanfei.sort;

import java.util.List;

/**
 * @author zhangjunshuai
 *  排序基础接口类
 */
public interface BaseSort<E> {
    /**
     *  排序基础接口
     * @param datalist
     * @return
     */
    List<E > sort(List<E> datalist);
}
