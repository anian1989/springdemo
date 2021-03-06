package com.fanhanfei.designmode.behaviorpattern.commandmodel.v2;

/**
 * @author zhangjunshuai
 * @date 2019/9/13
 * @description
 **/
public class TwoCommandV2 extends AbstractCommand {

    @Override
    public void execute() {
        receiver.actionTwo();
        receiver.actionOne();
    }
}
