package com.fanhanfei.common;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2019/12/31
 * @description 一些脚手架
 **/
public class HandleCommon {
    private static final Integer RONDOM_DEFAULT_START = NumberUtils.INTEGER_ZERO;
    private static final Integer RONDOM_DEFAULT_END = Integer.valueOf(1000000);

    public static Integer getRondomInt(){
        return getRondomInt(RONDOM_DEFAULT_START,RONDOM_DEFAULT_END);
    }

    public static Integer getRondomInt(Integer start,Integer end){
        return RandomUtils.nextInt(start, end);
    }

    /**
     * 若end-start<size 则会启用默认start和end
     * @param start
     * @param end
     * @param size
     * @return
     */
    public static List<Integer> getRondomIntListNoRepeat(Integer start,Integer end,Integer size){
        ArrayList<Integer> results = Lists.newArrayListWithCapacity(size);
        if ((end - start)<size){
            start = RONDOM_DEFAULT_START;
            end = RONDOM_DEFAULT_END;
        }
        for (int i =0;i<size;i++) {
            Integer rondomInt ;
            while (true){
                rondomInt = getRondomInt(start, end);
                if (!results.contains(rondomInt)) {
                    break;
                }
            }
            results.add(rondomInt);
        }
        return results;
    }
    public static List<Integer> getRondomIntList(Integer start,Integer end,Integer size){
        ArrayList<Integer> results = Lists.newArrayListWithCapacity(size);
        for (int i =0;i<size;i++) {
            results.add(getRondomInt(start,end));
        }
        return results;
    }

    public static List<Integer> getRondomIntList(Integer start,Integer size){
        return getRondomIntList(start,RONDOM_DEFAULT_END,size);
    }

    public static List<Integer> getRondomIntList(Integer size){
        return getRondomIntList(RONDOM_DEFAULT_START,RONDOM_DEFAULT_END,size);
    }

    public static void  printList(String disName,List<?> list){
        if (CollectionUtils.isEmpty(list)) {
            System.out.println("打印信息，入参为空");
            return;
        }
        System.out.println("========================="+disName+"打印信息=========================");
        for (Object t : list) {
            System.out.print(t.toString()+",");
        }
        System.out.println();
    }

    public static  void exchange(List list,int i,int j){
        if (CollectionUtils.isEmpty(list)
                ||i == j){
            return;
        }
        Object comparable = list.get(i);
        list.set(i,list.get(j));
        list.set(j,comparable);
    }


}
