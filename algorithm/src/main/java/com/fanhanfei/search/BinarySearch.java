package com.fanhanfei.search;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2020/1/15
 * @description
 **/
public class BinarySearch implements BaseSearch{

    /**
     * 二分查找的前提是 有序序列
     * @param sortList
     * @param target
     * @return
     */
    @Override
    public <T> Integer search(List<? extends Comparable<T>> sortList, T target) {
        if (CollectionUtils.isEmpty(sortList)) {
            return -1;
        }
        int size = sortList.size();
        int start = 0;
        int end = size-1;

        while (start<=end){
//            int middle = Math.floorDiv(end+start, 2);
            //防止end+start超出上限；
            // 右移更高效
            int middle = start+((end-start)>>1);
            Comparable<T> comparable = sortList.get(middle);
            if (comparable.compareTo(target) == 0) {
                return middle;
            }
            if (comparable.compareTo(target)<0) {
                start = middle+1;
            }
            if (comparable.compareTo(target)>0) {
                end = middle-1;
            }
        }

        return -1;
    }
}
