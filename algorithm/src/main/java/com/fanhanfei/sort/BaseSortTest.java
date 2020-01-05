package com.fanhanfei.sort;

import com.fanhanfei.common.HandleCommon;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2019/12/31
 * @description
 **/
public class BaseSortTest {
    public static List<List<Integer>> failList= Lists.newArrayList();
    public static void main(String[] args) {
//        test(new BubbleSort());
//        test(new SelectionSort());
//        test(new InsertSort());
        test(new ShellSort());
    }

    public static void checkResult(List<Integer> rondomIntList){
        System.out.println("******************************************");
        if (CollectionUtils.isNotEmpty(rondomIntList)) {
            Boolean flag = true;
            for (int i = 1; i < rondomIntList.size(); i++) {
                if (rondomIntList.get(i)<rondomIntList.get(i-1)){
                    flag = false;
                    break;
                }
            }
            if (!flag){
                failList.add(rondomIntList);
                System.out.println("测试结果有问题");
            }else {
                System.out.println("Good Job");
            }
        }else {
            System.out.println("list is empty");
        }
    }
    public static void test(BaseSort sort){

        int sizeMax = 10;
        int end = sizeMax <<1;
        for (int i=2;i<sizeMax;i++){
            test(sort,0,end,i);
        }

        printFail(sort);

    }

    public static void printFail(BaseSort sort){
        System.out.println("失败是");
        if (CollectionUtils.isNotEmpty(failList)) {
            for (List<Integer> integers : failList) {

                HandleCommon.printList(sort.sortName(),integers);
            }
        }
    }

    public static void test(BaseSort sort,Integer start,Integer end,Integer size){
        List<Integer> rondomIntList = HandleCommon.getRondomIntListNoRepeat(start, end, size);
        sort.sort(rondomIntList);
        checkResult(rondomIntList);
    }
}
