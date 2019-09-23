package com.fanhanfei.designmode.behaviorpattern.commandmodel.v2;

import com.fanhanfei.designmode.behaviorpattern.commandmodel.Command;
import com.fanhanfei.designmode.behaviorpattern.commandmodel.Receiver;

/**
 * @author zhangjunshuai
 * @date 2019/9/13
 * @description 结合模板工厂模式
 **/
public class AbstractCommand implements Command {
    protected ReceiverV2 receiver ;

    public AbstractCommand() {
        this.receiver = new ReceiverV2();
    }

    public AbstractCommand(ReceiverV2 receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.actionOne();
        receiver.actionTwo();
    }
}
