package com.fanhanfei.designmode.behaviorpattern.commandmodel.v2;

import com.fanhanfei.designmode.behaviorpattern.commandmodel.Invoker;

/**
 * @author zhangjunshuai
 * @date 2019/9/13
 * @description
 **/
public class ClientV2 {
    public static void main(String[] args) {
        OneCommandV2 oneCommandV2 = new OneCommandV2();
        Invoker invoker = new Invoker(oneCommandV2);
        invoker.action();

        TwoCommandV2 twoCommandV2 = new TwoCommandV2();
        Invoker invoker1 = new Invoker(twoCommandV2);
        invoker1.action();
    }
}
