package com.springdb.demo;

import com.springdb.demo.mapper2.WarehouseAreaLimitBakMapper;
import com.springdb.demo.model.WarehouseAreaLimitBak;
import com.springdb.demo.springtransaction.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author zhangjunshuai
 * @date 2019/10/16
 * @description
 **/
@Slf4j
public class TransactionTests extends BaseTest {

    @Resource
    private TransactionService transactionService;
    @Test
    public void testTransaction(){
        System.out.println(transactionService.getClass());
        transactionService.onServiceMethod();

    }
}
