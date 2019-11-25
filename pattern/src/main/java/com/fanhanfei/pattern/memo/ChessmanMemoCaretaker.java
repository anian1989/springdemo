package com.fanhanfei.pattern.memo;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.ArrayList;

/**
 * @author zhangjunshuai
 * @date 2019/11/19
 * @description
 **/
@Data
public class ChessmanMemoCaretaker {
    private ArrayList<ChessmanMemo> list = Lists.newArrayList();
    public ChessmanMemo getMemo(int i){
        return list.get(i);
    }

    public void addMemo(ChessmanMemo memo){
        list.add(memo);
    }
}
