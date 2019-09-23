package com.fanhanfei.designmode.behaviorpattern.commandmodel;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjunshuai
 * @date 2019/9/13
 * @description 命令模式-接受者（命令实际执行人）
 **/
@Slf4j
public class Receiver {

    public void actionOne(){
        log.info("========actionOne=======");
    }

    public void actionTwo(){
        log.info("========actionTwo=======");
    }
}
