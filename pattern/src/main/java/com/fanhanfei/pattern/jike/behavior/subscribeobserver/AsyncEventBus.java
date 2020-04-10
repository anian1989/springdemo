package com.fanhanfei.pattern.jike.behavior.subscribeobserver;

import java.util.concurrent.Executor;

/**
 * @author zhangjunshuai
 * @date 2020/4/7
 * @description
 **/
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
