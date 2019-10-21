package com.springdb.demo.dbservice;

import com.springdb.demo.config.dynamicdatasource.DS;
import com.springdb.demo.mapper.SkuChannelSnapshotCompareMapper;
import com.springdb.demo.model.SkuChannelSnapshotCompare;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2019/10/21
 * @description
 **/
@Repository
public class SkuChannelSnapshotCompareDao {
    @Resource
    private SkuChannelSnapshotCompareMapper skuChannelSnapshotCompareMapper;


    @DS
    public String ds(Long id) {
        List<SkuChannelSnapshotCompare> byId = skuChannelSnapshotCompareMapper.getById(id);
        return byId.get(0).getId().toString();
    }

    @DS("primaryDataSourceRead")
    public String dsRead(Long id) {
        List<SkuChannelSnapshotCompare> byId = skuChannelSnapshotCompareMapper.getById(id);
        return byId.get(0).getId().toString();
    }

}
