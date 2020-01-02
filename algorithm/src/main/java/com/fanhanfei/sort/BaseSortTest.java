package com.fanhanfei.sort;

import com.fanhanfei.common.HandleCommon;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2019/12/31
 * @description
 **/
public class BaseSortTest {
    public static void main(String[] args) {
//        test(new BubbleSort());
//        test(new SelectionSort());
        test(new InsertSort());
    }

    public static void checkResult(List<Integer> rondomIntList){
        System.out.println("*********************");
        if (CollectionUtils.isNotEmpty(rondomIntList)) {
            Boolean flag = true;
            for (int i = 1; i < rondomIntList.size(); i++) {
                if (rondomIntList.get(i)<rondomIntList.get(i-1)){
                    flag = false;
                    break;
                }
            }
            if (!flag){
                System.out.println("测试结果有问题");
            }else {
                System.out.println("Good Job");
            }
        }else {
            System.out.println("list is empty");
        }
    }
    public static void test(BaseSort sort){
        List<Integer> rondomIntList = HandleCommon.getRondomIntListNoRepeat(0, 100, 10);
        sort.sort(rondomIntList);
        checkResult(rondomIntList);

    }
}
