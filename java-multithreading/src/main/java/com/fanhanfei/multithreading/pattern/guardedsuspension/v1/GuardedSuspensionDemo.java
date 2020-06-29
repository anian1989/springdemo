package com.fanhanfei.multithreading.pattern.guardedsuspension.v1;

/**
 * @author zhangjunshuai
 * @date 2020/6/22
 * @description
 **/
public class GuardedSuspensionDemo {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();
        new ClientThread(messageQueue,"clientThrea",3141592L).start();
        new ServerThread(messageQueue,"serverThread",6535897L).start();
    }
}
