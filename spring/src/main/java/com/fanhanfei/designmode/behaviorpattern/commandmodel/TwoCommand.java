package com.fanhanfei.designmode.behaviorpattern.commandmodel;

/**
 * @author zhangjunshuai
 * @date 2019/9/13
 * @description
 **/
public class TwoCommand implements Command {
    private Receiver receiver = null;


    public TwoCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public TwoCommand() {
        this.receiver=new Receiver();
    }

    @Override
    public void execute() {
        receiver.actionTwo();
        receiver.actionOne();
    }
}
