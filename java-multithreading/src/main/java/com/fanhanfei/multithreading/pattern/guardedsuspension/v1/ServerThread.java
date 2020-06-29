package com.fanhanfei.multithreading.pattern.guardedsuspension.v1;

import java.util.Random;

/**
 * @author zhangjunshuai
 * @date 2020/6/22
 * @description
 **/
public class ServerThread extends Thread {
    private final Random random;
    private final MessageQueue messageQueue;
    public ServerThread(MessageQueue messageQueue,String name,long seed){
        super(name);
        this.random = new Random(seed);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i <10000 ; i++) {
            RequestMessage request = messageQueue.getRequest();
            System.out.println(Thread.currentThread().getName() +" handles:"+request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
