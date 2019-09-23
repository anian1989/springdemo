package com.fanhanfei.designmode.behaviorpattern.commandmodel;

/**
 * @author zhangjunshuai
 * @date 2019/9/13
 * @description
 **/
public class Client {
    public static void main(String[] args) {
        OneCommand oneCommand = new OneCommand();
        Invoker invoker = new Invoker(oneCommand);
        invoker.action();


        TwoCommand twoCommand = new TwoCommand();
        Invoker invoker1 = new Invoker(twoCommand);
        invoker1.action();


    }
}
