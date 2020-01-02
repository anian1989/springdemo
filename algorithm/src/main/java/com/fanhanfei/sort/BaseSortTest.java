package com.fanhanfei.sort;

import com.fanhanfei.common.HandleCommon;

import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2019/12/31
 * @description
 **/
public class BaseSortTest {
    public static void main(String[] args) {
        test(new BubbleSort());
        test(new SelectionSort());
    }

    public static void test(BaseSort sort){
        List<Integer> rondomIntList = HandleCommon.getRondomIntList(0, 20, 2);
        sort.sort(rondomIntList);

    }
}
