package com.fanhanfei.pattern.memo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhangjunshuai
 * @date 2019/11/19
 * @description
 **/
@Data
@AllArgsConstructor
public class Chessman {
    private String label;
    private int x;
    private int y;

    /**
     * 保存状态
     * @return
     */
    public ChessmanMemo createMemo() {
        return new ChessmanMemo(this.label,this.x,this.y);
    }

    /**
     * 恢复状态
     * @param memento
     */
    public void restore(ChessmanMemo memento) {
        this.label = memento.getLabel();
        this.x = memento.getX();
        this.y = memento.getY();
    }
}
