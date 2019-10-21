package com.springdb.demo.mapper;

import com.springdb.demo.model.SkuChannelSnapshotCompare;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SkuChannelSnapshotCompareMapper {
    @Select("select * from stock_snapshot_compare where diff_stock !=0 " +
            "and warehouse_id=#{warehouseId} " +
            "and sku_store_type=#{skuType} " +
            "and data_date=#{dataDate}")
    List<SkuChannelSnapshotCompare> getAll(@Param("warehouseId") Integer warehouseId
            , @Param("skuType") String skuType, @Param("dataDate") String dataDate);

    @Select("select * from stock_snapshot_compare where " +
            "diff_stock =#{diffStock} " +
            "and warehouse_id=#{warehouseId} " +
            "and sku_store_type=#{skuType} " +
            "and sku_code=#{skuCode} " +
            "and data_date>=#{dataDateStart} " +
            "and data_date<=#{dataDateEnd}")
    List<SkuChannelSnapshotCompare> getDetail(@Param("diffStock") Integer diffStock
            , @Param("warehouseId") Integer warehouseId
            , @Param("skuCode") Long skuCode
            , @Param("skuType") String skuType
            , @Param("dataDateStart") String dataDateStart
            , @Param("dataDateEnd") String dataDateEnd
    );

    @Select("select * from stock_snapshot_compare limit 0,10")
    List<SkuChannelSnapshotCompare> getById(@Param("id") Long id);

    /*@Insert({"insert into user(name,age,pwd) values(#{name},#{age},#{pwd})"})
    void install(User user);

    @Update({"update user set name=#{name} where id=#{id}"})
    void Update(User user);

    @Delete("delete from user where id=#{id}")
    void delete(Long id);*/
}
