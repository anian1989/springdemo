package com.springdb.demo;

import com.springdb.demo.mapper2.WarehouseAreaLimitBakMapper;
import com.springdb.demo.model.WarehouseAreaLimitBak;
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
    WarehouseAreaLimitBakMapper warehouseAreaLimitBakMapper;
    @Test
    public void testTransaction(){
        WarehouseAreaLimitBak warehouseAreaLimitBak = new WarehouseAreaLimitBak();
        warehouseAreaLimitBak.setAreaId("1");
        warehouseAreaLimitBak.setWareId(78);
        warehouseAreaLimitBakMapper.insert(warehouseAreaLimitBak);
    }
}
