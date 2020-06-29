package com.fanhanfei.multithreading.pattern.guardedsuspension.v1;

import java.util.Random;

/**
 * @author zhangjunshuai
 * @date 2020/6/22
 * @description
 **/
public class ClientThread extends Thread {
    private final Random random;
    private final MessageQueue messageQueue;
    public ClientThread(MessageQueue messageQueue,String name,long seed){
        super(name);
        this.random = new Random(seed);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            RequestMessage requestMessage = new RequestMessage();
            requestMessage.setId("No."+i);
            System.out.println(Thread.currentThread().getName() + "  request:"+requestMessage);
            messageQueue.putRequest(requestMessage);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
