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
public class ChessmanMemo {
    private String label;
    private int x;
    private int y;
}
