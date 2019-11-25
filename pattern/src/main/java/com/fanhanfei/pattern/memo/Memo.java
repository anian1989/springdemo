package com.fanhanfei.pattern.memo;

import lombok.Data;

/**
 * @author zhangjunshuai
 * @date 2019/11/18
 * @description 备忘录模式 备忘录类
 **/
@Data
public class Memo {
    private String state;

    public Memo(Originator o) {
        this.state = o.getState();
    }

}
