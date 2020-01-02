package com.fanhanfei.sort;

import com.fanhanfei.common.HandleCommon;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2019/12/31
 * @description 冒泡排序
 **/
public class BubbleSort extends AbstractBaseSort{

    @Override
    public List<? extends Comparable> sortImp(List<? extends Comparable> datalist) {
        int size = datalist.size();
        if (NumberUtils.INTEGER_ONE.equals(size)){
            return datalist;
        }
        for (int i = 0 ; i < size ; i++) {
            //如果一次冒泡没有进行过交换说明已经有序了
            Boolean exchangeFlag = Boolean.FALSE;
            for (int j = size-1; j >i ; j--) {
                Comparable comparableLowe = datalist.get(j);
                Comparable comparableHigh = datalist.get(j - 1);
                if (comparableLowe.compareTo(comparableHigh) < NumberUtils.INTEGER_ZERO){
                    HandleCommon.exchange(datalist,j,j-1);
                    exchangeFlag = Boolean.TRUE;
                }
            }
            if (BooleanUtils.isFalse(exchangeFlag)){
                System.out.println("冒泡次数："+(i+1));
                break;
            }
        }
        return datalist;
    }
}
