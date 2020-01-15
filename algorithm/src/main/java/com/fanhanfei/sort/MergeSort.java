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

    public void merge(List<E> dataList,Integer start,Integer end){
        if (start>=end){
            return;
        }
        Integer middle = start +Math.floorDiv(end-start,2);
        merge(dataList,start,middle);
        merge(dataList,middle+1,end);
        mergeAll(dataList,start,middle,end);
    }

    public void mergeAll(List<E> dataList,Integer start,Integer middle,Integer end){
        int size = end - start + 1;
        int leftPoint = start;
        int rightPoint = middle+1;
        ArrayList<E> tempList = Lists.newArrayListWithCapacity(size);
        int i=0;
        while (leftPoint<=middle&&rightPoint<=end){
            E e = dataList.get(leftPoint).compareTo(dataList.get(rightPoint)) > 0 ? dataList.get(rightPoint++) : dataList.get(leftPoint++);
            tempList.add(i++,e);
        }

        while (leftPoint<=middle){
            tempList.add(i++,dataList.get(leftPoint++));
        }
        while (rightPoint<=end){
            tempList.add(i++,dataList.get(rightPoint++));
        }
        for (E e : tempList) {
            dataList.set(start++,e);
        }
    }


}
