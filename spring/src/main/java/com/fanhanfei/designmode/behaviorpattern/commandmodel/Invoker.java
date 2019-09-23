package com.fanhanfei.designmode.behaviorpattern.commandmodel;

/**
 * @author zhangjunshuai
 * @date 2019/9/13
 * @description 命令模式-接受者（接收命令的人，类似项目组的产品经理接收业务方的需求）
 **/
public class Invoker {
    private Command command=null;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(){
        this.command.execute();
    }
}
