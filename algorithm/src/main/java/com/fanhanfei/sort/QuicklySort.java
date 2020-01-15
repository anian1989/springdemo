package com.fanhanfei.sort;

import com.fanhanfei.common.HandleCommon;

import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2020/1/6
 * @description
 **/
public class QuicklySort<E extends Comparable> extends AbstractBaseSort<E> {
    /**
     * 排序名称
     *
     * @return
     */
    @Override
    public String sortName() {
        return "快速排序";
    }

    @Override
    public List<E> sortImp(List<E> datalist) {
        int size = datalist.size();
        quick(datalist,0,size-1);
        return datalist;
    }

    public void quick(List<E> dataList,int start,int end){
        int left = start;
        int right = end;
        int pivotIndex = (start+end)/2;
        if (start>= end){
            return;
        }
        E e = dataList.get(pivotIndex);
        while (left<=right){
            while (dataList.get(left).compareTo(e)<0){
                left++;
            }
            while (dataList.get(right).compareTo(e)>0){
                right--;
            }
            if (left<right){
                HandleCommon.exchange(dataList,left++,right--);
            }else if (left== right){
                left++;//?为什么呢？
            }
        }
        quick(dataList,start,right);
        quick(dataList,left,end);
    }
}
