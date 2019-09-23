package com.fanhanfei.designmode.behaviorpattern.commandmodel;

/**
 * @author zhangjunshuai
 * @date 2019/9/13
 * @description
 **/
public class OneCommand implements Command {
    private Receiver receiver = null;
    public OneCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public OneCommand() {
        this.receiver = new Receiver();
    }

    @Override
    public void execute() {
        receiver.actionOne();
        receiver.actionTwo();
    }
}
