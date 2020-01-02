package com.fanhanfei.sort;

import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2020/1/2
 * @description 插入排序
 * 有两种方式
 **/
public class InsertSort<E extends Comparable> extends AbstractBaseSort<E>{
    @Override
    public List<E> sortImp(List<E> dataList) {
        int size = dataList.size();
        for (int i = 1; i < size; i++) {
            E underMindedE = dataList.get(i);
            int j = i-1;
            for (; j >-1&&underMindedE.compareTo(dataList.get(j))<0 ; j--) {
                dataList.set(j+1,dataList.get(j));
            }
            dataList.set(j+1,underMindedE);
        }
        return dataList;
    }

    public List<E> sortImpV1(List<E> datalist) {
        int size = datalist.size();
        for (int i = 1; i < size; i++) {
            E undermindObject = datalist.get(i);
            for (int j = i-1; j >-1 ; j--) {
                E e = datalist.get(j);
                if (undermindObject.compareTo(e) <0){
                    datalist.set(j+1,e);
                    datalist.set(j,undermindObject);
                }else {
                    break;
                }

            }
        }
        return datalist;
    }


}
