package com.fanhanfei.sort;

import com.fanhanfei.common.HandleCommon;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2019/12/31
 * @description
 **/
public class SelectionSort<T extends Comparable> extends AbstractBaseSort<T>{
    @Override
    public List<T> sortImp(List<T> datalist) {
        int size = datalist.size();
        for (int i = 0; i < size; i++) {
            int minIndex = i;
            for (int j = i+1; j < size ; j++) {
                if (datalist.get(j).compareTo(datalist.get(minIndex))< NumberUtils.INTEGER_ZERO){
                    minIndex = j ;
                }
            }
            HandleCommon.exchange(datalist,i,minIndex);
        }
        return datalist;
    }

    /**
     * 排序名称
     *
     * @return
     */
    @Override
    public String sortName() {
        return "选择排序";
    }
}
