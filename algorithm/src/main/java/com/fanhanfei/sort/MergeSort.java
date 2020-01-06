package com.fanhanfei.sort;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2020/1/5
 * @description
 **/
public class MergeSort<E extends Comparable> extends AbstractBaseSort<E> {
    /**
     * 排序名称
     *
     * @return
     */
    @Override
    public String sortName() {
        return "归并排序";
    }

    @Override
    public List<E> sortImp(List<E> datalist) {
        merge(datalist,0,datalist.size()-1);
        return datalist;
    }

    private void merge(List<E> dataList,int start,int end){
        if (start >= end){
            return;
        }
        int middle = start +Math.floorDiv(end-start,2);
        merge(dataList,start,middle);
        merge(dataList,middle+1,end);
        mergeSort(dataList,start,middle+1,end);
    }

    private void mergeSort(List<E> dataList,int start,int middle,int end){
        int leftPoint= start;
        int rightPoint = middle;
        int size = end - start + 1;
        ArrayList<E> resultList = Lists.newArrayListWithCapacity(size);
        int i =0;
        while(leftPoint <middle&&rightPoint<=end){
            E e = dataList.get(leftPoint).compareTo(dataList.get(rightPoint)) < 0 ? dataList.get(leftPoint++) : dataList.get(rightPoint++);
            resultList.add(i++,e);
        }
        while (leftPoint < middle){
            resultList.add(i++,dataList.get(leftPoint++)) ;
        }
        while (rightPoint<=end){
            resultList.add(i++,dataList.get(rightPoint++)) ;
        }
        for (int j = 0; j < resultList.size(); j++) {
            dataList.set(start+j,resultList.get(j));
        }
    }
}
