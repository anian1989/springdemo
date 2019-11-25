package com.fanhanfei.common;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.util.*;

/**
 * @author zhangjunshuai
 * @date 2019/11/4
 * @description
 **/
public class OtherTest {

    public static void main(String[] args) {
        String   regEx  =  "^[0-9\\*]+$";
        String test ="123123123A";
        System.out.println(test.matches(regEx));

        System.out.println(NumberUtils.isNumber("-1"));
        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0;i<41;i++){
            stringBuilder.append("TM573133101653211003S0_"+i+",");
        }
        System.out.println(stringBuilder.toString());

        if (StringUtils.equals("",null)) {

        }

        ArrayList<Integer> intList = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            intList.add(i);
        }
        Iterator<Integer> iterator = intList.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next.equals(5)) {
                iterator.remove();
            }
        }

        ListIterator<Integer> integerListIterator = intList.listIterator(intList.size());
        while (integerListIterator.hasPrevious()) {
            System.out.println(integerListIterator.previous());
        }

    }
}
