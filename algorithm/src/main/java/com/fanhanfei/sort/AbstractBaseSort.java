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
public  abstract class AbstractBaseSort implements BaseSort {

    abstract List<? extends Comparable > sortImp(List<? extends Comparable> datalist);

    @Override
    public List<? extends Comparable> sort(List<? extends Comparable> datalist) {
        if (CollectionUtils.isEmpty(datalist)) {
            System.out.println("入参为空");
            return null;
        }
        HandleCommon.printList(datalist);
        List<? extends Comparable> comparables = sortImp(datalist);
        HandleCommon.printList(comparables);
        return datalist;
    }
}
