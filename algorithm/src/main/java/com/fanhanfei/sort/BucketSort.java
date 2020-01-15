package com.fanhanfei.sort;


import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2020/1/7
 * @description
 **/
public class BucketSort<E  extends Integer> extends AbstractBaseSort<E> {

    /**
     * 排序名称
     *
     * @return
     */
    @Override
    public String sortName() {

        return "桶排序";
    }

    @Override
    public List<E> sortImp(List<E> datalist) {

        E max = datalist.get(0);
        E min = datalist.get(0);
        for (E e : datalist) {
            if (e.compareTo(max)>0){
                max = e;
            }
            if (e.compareTo(min)<0){
                min = e;
            }
        }
        int step = 10;
        int maxInt = max.intValue();
        int minInt = min.intValue();
        Integer bucketCount = (maxInt - minInt)/10+1;
        List<E>[] resultList = new ArrayList[bucketCount];
        for (E e : datalist) {
            int i = e.intValue() - minInt;
            int i1 = i / step;
            List<E> es = resultList[i1];
            if (CollectionUtils.isEmpty(es)) {
                es = Lists.newArrayList();
            }
            es.add(e);
            resultList[i1]=es;
        }
        ArrayList<E> objects = Lists.newArrayListWithCapacity(datalist.size());
        for (int i = 0; i < resultList.length; i++) {
            List<E> es = resultList[i];
            if (CollectionUtils.isNotEmpty(es)) {
                QuicklySort<E> eQuicklySort = new QuicklySort<>();
                List<E> sort = eQuicklySort.sort(es);
                objects.addAll(sort);
            }

        }
        return objects;
    }
}
