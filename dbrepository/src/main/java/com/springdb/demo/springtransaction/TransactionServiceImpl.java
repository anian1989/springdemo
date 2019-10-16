package com.springdb.demo.springtransaction;

import com.springdb.demo.mapper2.WarehouseAreaLimitBakMapper;
import com.springdb.demo.model.WarehouseAreaLimitBak;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangjunshuai
 * @date 2019/10/16
 * @description
 **/
@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {
    @Resource
    WarehouseAreaLimitBakMapper warehouseAreaLimitBakMapper;
    @Override
    public void onServiceMethod() {
        WarehouseAreaLimitBak warehouseAreaLimitBak = new WarehouseAreaLimitBak();
        warehouseAreaLimitBak.setAreaId("3");
        warehouseAreaLimitBak.setWareId(78);
        warehouseAreaLimitBakMapper.insert(warehouseAreaLimitBak);
        WarehouseAreaLimitBak warehouseAreaLimitBak1 = new WarehouseAreaLimitBak();
        warehouseAreaLimitBak1.setAreaId("2");
        warehouseAreaLimitBak1.setWareId(78);
        warehouseAreaLimitBakMapper.insert(warehouseAreaLimitBak1);
    }
}
