package com.fanhanfei.sort;

import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2020/1/2
 * @description
 **/
public class InsertSort<E extends Comparable> extends AbstractBaseSort<E>{
    @Override
    public List<E> sortImp(List<E> datalist) {
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
