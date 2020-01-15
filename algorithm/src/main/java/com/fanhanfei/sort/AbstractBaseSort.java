package com.fanhanfei.sort;

import com.fanhanfei.common.HandleCommon;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2019/12/31
 * @description
 **/
public  abstract class AbstractBaseSort<E  extends Comparable> implements BaseSort<E> {

    abstract public List<E > sortImp(List<E> datalist);

    @Override
    public List<E> sort(List<E> datalist) {
        if (CollectionUtils.isEmpty(datalist)) {
            System.out.println("入参为空");
            return null;
        }
        HandleCommon.printList(sortName(),datalist);
        if (datalist.size() == 1){
            return datalist;
        }
        List<E> comparAbles = sortImp(datalist);
        HandleCommon.printList(sortName(),comparAbles);
        return comparAbles;
    }
}
