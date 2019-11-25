package com.fanhanfei.pattern.memo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangjunshuai
 * @date 2019/11/18
 * @description 备忘录模式的原发器
 **/
@Data
@NoArgsConstructor
public class Originator {
    private String state;


// 创建一个备忘录对象

    public Memo createMemo() {
        return new Memo(this);
    }

// 根据备忘录对象恢复原发器状态

    public void restoreMemo(Memo m) {
        state = m.getState();
    }

}
