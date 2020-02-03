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

    /**
     * 在有重复数据的有序队列里面找到第一个指定值
     * @param sortList
     * @param target
     * @return
     */
    public Integer searchFirst(List<Integer> sortList,Integer target){
        int low =0;
        int hight= sortList.size()-1;
        while (hight>=low){
            int middle = low+((hight-low)>>1);
            if (sortList.get(middle)>target){
                hight = middle-1;
            }else if (sortList.get(middle)<target){
                low=middle+1;
            }else {
                if (low == 0 || !sortList.get(middle-1).equals(target)){
                    return middle;

                }else {
                    hight=middle-1;
                }
            }
        }
        return -1;
    }

    /**
     * 在有重复数据的有序队列里面找到最后一个指定值
     * @param sortList
     * @param target
     * @return
     */
    public Integer searchLast(List<Integer> sortList,Integer target){
        int low =0;
        int high = sortList.size()-1;
        while (low<=high){
            int mid = low+((high-low)>>1);
            if (sortList.get(mid)>target){
                high=mid-1;
            }else if (sortList.get(mid)<target){
                low = mid + 1;
            }else {
                if (mid == sortList.size()-1 || sortList.get(mid+1)>target){
                    return mid;
                }else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     * @param sortList
     * @param target
     * @return
     */
    public Integer searchGreaterOrEqualFirst(List<Integer> sortList,Integer target){
        int low = 0;
        int high = sortList.size()-1;
        while (low<=high){
            int mid = low +((high-low)>>1);
            if (sortList.get(mid)>= target){
                if (mid == 0 || sortList.get(mid-1)< target){
                    return target;
                }else {
                    high = mid -1;
                }
            }else {
                low = mid +1;
            }
        }
        return -1;

    }
}
