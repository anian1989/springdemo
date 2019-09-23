package com.springdb.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @author zhangjunshuai
 * @date 2019/9/20
 * @description
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Alias("")
public class SkuChannelSnapshotCompare extends BaseDO {
    private Long id;

    private Long skuId;

    private Long skuCode;

    private Integer warehouseId;

    private Date dataDate;

    private String skuStoreType;

    private String compareCode;

    private Integer channelId;

    private Integer channelStock;

    private Integer erpStock;

    private Integer diffStock;

    private Date createTime;

    private Date updateTime;

    private String createdBy;

    private String updatedBy;

    private Integer deleted;
}