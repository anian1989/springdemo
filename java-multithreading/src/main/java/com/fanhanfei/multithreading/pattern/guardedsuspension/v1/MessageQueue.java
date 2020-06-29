package com.fanhanfei.multithreading.pattern.guardedsuspension.v1;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangjunshuai
 * @date 2020/6/22
 * @description
 * synchronized 很重要
 **/
public class MessageQueue {

    private final Queue<RequestMessage> queue = new LinkedList<>();


    public  RequestMessage getRequest() {
        while ( queue.peek() == null) {
            try {
                synchronized (this){
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove();
    }

    public  void putRequest(RequestMessage message) {
        queue.offer(message);
        synchronized (this){
            notifyAll();
        }
    }
}
