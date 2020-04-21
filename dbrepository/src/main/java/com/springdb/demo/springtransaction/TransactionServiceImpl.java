package com.springdb.demo.springtransaction;

import com.springdb.demo.mapper2.WarehouseAreaLimitBakMapper;
import com.springdb.demo.model.WarehouseAreaLimitBak;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.rowset.serial.SerialException;

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
    @Transactional(rollbackFor = Exception.class)
    public void onServiceMethod() {
        try {
            WarehouseAreaLimitBak warehouseAreaLimitBak = new WarehouseAreaLimitBak();
            warehouseAreaLimitBak.setAreaId("33333588888");
            warehouseAreaLimitBak.setWareId(78);
            warehouseAreaLimitBakMapper.insert(warehouseAreaLimitBak);
            WarehouseAreaLimitBak warehouseAreaLimitBak1 = new WarehouseAreaLimitBak();
            warehouseAreaLimitBak1.setAreaId("2");
            warehouseAreaLimitBak1.setWareId(78);
            warehouseAreaLimitBakMapper.insert(warehouseAreaLimitBak1);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            WarehouseAreaLimitBak warehouseAreaLimitBak1 = new WarehouseAreaLimitBak();
            warehouseAreaLimitBak1.setAreaId("120");
            warehouseAreaLimitBak1.setWareId(120);
            warehouseAreaLimitBakMapper.insert(warehouseAreaLimitBak1);
            log.info("finally 执行了");
        }
    }
}
