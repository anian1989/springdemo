package com.fanhanfei.sort;

import com.fanhanfei.common.HandleCommon;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2019/12/31
 * @description 冒泡排序
 **/
public class BubbleSort {

    public static List<Integer> bubble(List<Integer> dataList){
        if (CollectionUtils.isEmpty(dataList)) {
            return null;
        }
        HandleCommon.printList(dataList);
        int size = dataList.size();
        for (int i = 0 ; i < size ; i++) {
            for (int j = size-1; j >i ; j--) {
                Integer integerLower = dataList.get(j);
                Integer integerHigh = dataList.get(j - 1);
                if (integerHigh > integerLower){
                    dataList.set(j,integerHigh);
                    dataList.set(j-1,integerLower);
                }
            }
        }
        HandleCommon.printList(dataList);
        return dataList;
    }

    public static void main(String[] args) {
        List<Integer> rondomIntList = HandleCommon.getRondomIntList(0,20,10);
        BubbleSort.bubble(rondomIntList);
    }
}
