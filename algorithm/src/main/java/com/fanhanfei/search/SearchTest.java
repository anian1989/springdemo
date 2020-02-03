package com.fanhanfei.search;

import com.fanhanfei.common.HandleCommon;
import com.fanhanfei.sort.QuicklySort;

import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2020/1/15
 * @description
 **/
public class SearchTest {
    public static void main(String[] args) {
        QuicklySort<Integer> integerQuicklySort = new QuicklySort<>();
        List<Integer> rondomIntList = HandleCommon.getRondomIntListNoRepeat(0, 100000, 10);
        List sortResult = integerQuicklySort.sort(rondomIntList);
        HandleCommon.printList("排序好的",sortResult);
        BaseSearch baseSearch = new BinarySearch();
        Integer search = baseSearch.search(sortResult, 0);
        System.out.println("结果："+search);


        List<Integer> rondomIntList1 = HandleCommon.getRondomIntList(0, 10, 15);
        List<Integer> sort = integerQuicklySort.sort(rondomIntList1);
        HandleCommon.printList("排序好的",sort);
        Integer integer = ((BinarySearch)baseSearch).searchFirst(sort, 5);
        System.out.println("结果："+integer);
    }
}
