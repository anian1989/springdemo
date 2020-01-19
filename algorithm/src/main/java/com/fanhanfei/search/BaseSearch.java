package com.fanhanfei.search;

import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2020/1/15
 * @description
 **/
public interface BaseSearch {
    /**
     *
     * @param sortList
     * @param target
     * @param <T>
     * @return
     */
    <T> Integer search(List<? extends Comparable<T>> sortList,T target);
}
