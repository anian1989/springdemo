package com.springdb.demo.mapper2;

import com.springdb.demo.model.WarehouseAreaLimitBak;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhangjunshuai
 * @date 2019/10/16
 * @description
 **/
@Mapper
public interface WarehouseAreaLimitBakMapper {
    @Insert({"insert into warehouse_area_limit_bak(area_id,ware_id) values(#{areaId},#{wareId})"})
    void insert(WarehouseAreaLimitBak user);
}
