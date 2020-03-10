package com.fanhanfei.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author zhangjunshuai
 * @date 2020/2/3
 * @description
 **/
@Slf4j
@DisplayName("测试")
public class WmsTest extends BaseTest{
    static String logisticsOrderNo;
    static Integer warehouseId ;
    @BeforeAll
    static void before(){
        log.info("开始执行");
        warehouseId = 44;
        logisticsOrderNo="SANMA205330734960156672";
    }
    @DisplayName("测试转仓")
    @Test
    public void testChangeWarehouse(){
        String url = "https://store.gotokeep.com/api/internal/v1.0/wmsLogisticsOrder/submit";
        String[] split = logisticsOrderNo.replaceAll("\n", "").split(",");

        ArrayList<String> list = Lists.newArrayList(split);
        List<List<String>> partition = Lists.partition(list, 1);
        for (List<String> strings : partition) {
            HashMap<String, Object> objectObjectHashMap = Maps.newHashMap();
            objectObjectHashMap.put("logisticsOrderNoList", strings);
            objectObjectHashMap.put("warehouseId", warehouseId);
            String s ;
            try {
                s = HttpClient.sendPost(url, JSONObject.toJSONString(objectObjectHashMap));
                log.info("调用接口的结果是:{}", s);
                JSONObject jsonObject = JSONObject.parseObject(s);
                JSONObject data1 = jsonObject.getJSONObject("data");
                JSONArray successList = data1.getJSONArray("successList");
                JSONArray failList = data1.getJSONArray("failList");
                if (Objects.nonNull(failList) && CollectionUtils.isNotEmpty(failList)) {
                    log.error("失败的情况，{}", failList.toJSONString());
                }
                if (Objects.nonNull(successList) && CollectionUtils.isNotEmpty(successList)) {
                    log.info("成功的情况，{}", successList.toJSONString());
                }
            } catch (Exception e) {
                log.error("调用接口异常", e);
            }
        }
    }
    @AfterAll
    static void after(){
        log.info("结束执行");
    }
}
