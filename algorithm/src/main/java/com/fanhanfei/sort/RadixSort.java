package com.fanhanfei.sort;

import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2020/1/15
 * @description
 * @TODO
 **/
public class RadixSort<E extends Integer> extends AbstractBaseSort<E> {
    @Override
    public List<E> sortImp(List<E> datalist) {
        return null;
    }

    /**
     * 排序名称
     *
     * @return
     */
    @Override
    public String sortName() {
        return "基数排序";
    }
}
