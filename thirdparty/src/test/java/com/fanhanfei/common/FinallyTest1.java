package com.fanhanfei.common;

/**
 * @author zhangjunshuai
 * @date 2019/9/25
 * @description
 **/
public class FinallyTest1 {
    public static void main(String[] args) {

        System.out.println(test1());
    }

    public static int test1() {
        int b = 20;

        try {
            System.out.println("try block");
            throw new Exception("tt");
//            return b += 80;
        }
        catch (Exception e) {

            System.out.println("catch block");
        }
        finally {

            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }
        }

        return b;
    }
}
