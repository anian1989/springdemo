package com.fanhanfei.pattern.jike.behavior.model;

/**
 * @author zhangjunshuai
 * @date 2020/4/17
 * @description
 **/
public class ShutdownHookDemo{
    private static class ShutdownHook extends Thread {
        @Override
        public void run() {
            System.out.println("Hook Hook");
        }
    }

    public static void main(String[] args) {

      Runtime.getRuntime().addShutdownHook(new ShutdownHook());
    }
}
