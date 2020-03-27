package com.springdb.demo;

import com.springdb.demo.dbservice.SkuChannelSnapshotCompareDao;
import com.springdb.demo.springtransaction.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import java.sql.*;

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
    @Resource
    private SkuChannelSnapshotCompareDao skuChannelSnapshotCompareDao;
    @Test
    public void testDynamic(){
        Long id = 24L;
        String ds = skuChannelSnapshotCompareDao.ds(id);
        String s = skuChannelSnapshotCompareDao.dsRead(id);
        log.info("写库："+ds);
        log.info("读库："+s);
    }



}
