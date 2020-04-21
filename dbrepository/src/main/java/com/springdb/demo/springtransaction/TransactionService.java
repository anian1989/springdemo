package com.springdb.demo.springtransaction;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangjunshuai
 * @date 2019/10/16
 * @description
 **/
public interface TransactionService {
//    @Transactional(rollbackFor = Exception.class)
    void onServiceMethod();
}
