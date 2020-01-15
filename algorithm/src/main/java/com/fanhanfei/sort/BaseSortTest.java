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
    public  List<List<Integer>> failList= Lists.newArrayList();
    public static void main(String[] args) {
        BaseSortTest baseSortTest = new BaseSortTest();
//        baseSortTest.test(new BubbleSort());
//        baseSortTest.test(new SelectionSort());
//        baseSortTest.test(new InsertSort());
//        baseSortTest.test(new ShellSort());
//        baseSortTest.test(new MergeSort());
//        baseSortTest.test(new QuicklySort());
        baseSortTest.test(new BucketSort());
    }

    public  void testOne(BaseSort sort){

        List<Integer> rondomIntList = Lists.newArrayList(12,9,15);
        List sortResultList = sort.sort(rondomIntList);
        checkResult(sortResultList);

        printFail(sort);

    }


    public  void test(BaseSort sort){

        int sizeMax = 10;
        int end = sizeMax <<1;
        for (int i=2;i<sizeMax;i++){
            test(sort,0,end,i);
        }

        printFail(sort);

    }

    public  void printFail(BaseSort sort){
        if (CollectionUtils.isNotEmpty(failList)) {
            System.out.println("失败是");
            for (List<Integer> integers : failList) {
                HandleCommon.printList(sort.sortName(),integers);
            }
        }
    }

    public  void test(BaseSort sort,Integer start,Integer end,Integer size){
        List<Integer> rondomIntList = HandleCommon.getRondomIntListNoRepeat(start, end, size);
        List sortResult = sort.sort(rondomIntList);
        checkResult(sortResult);
    }
    public  void checkResult(List<Integer> rondomIntList){
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
}
