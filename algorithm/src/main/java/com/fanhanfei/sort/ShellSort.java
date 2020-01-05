package com.fanhanfei.sort;

import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2020/1/2
 * @description 希尔排序，步进式插入排序，注意不同的步进值会导致结果不同
 **/
public class ShellSort<E  extends Comparable>  extends AbstractBaseSort<E> {
    private static final int STANDARD = 2;
    @Override
    public List<E> sortImp(List<E> dataList) {
        int size = dataList.size();
        for (int step = size/STANDARD; step >0 ; step=step/STANDARD) {
            System.out.println("step"+step);
            for (int j = step; j <size ; j++) {
                int k = j-step;
                E underMindE = dataList.get(j);
                while (k>-1&&dataList.get(k).compareTo(underMindE)>0){
                    dataList.set(k+step,dataList.get(k));
                    k=k-step;
                }
                dataList.set(k+step,underMindE);
            }
        }
        return dataList;
    }

    /**
     * 排序名称
     *
     * @return
     */
    @Override
    public String sortName() {
        return "希尔排序";
    }
}
