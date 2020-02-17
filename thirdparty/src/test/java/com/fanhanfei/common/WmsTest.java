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
        warehouseId = 55;
        logisticsOrderNo="198709717466664960,\n" +
                "198709727436521472,\n" +
                "198709808227209216,\n" +
                "198709814061486080,\n" +
                "198709844575043584,\n" +
                "198709875071832064,\n" +
                "198709881027739648,\n" +
                "198709990050283520,\n" +
                "198710162398433280,\n" +
                "198710173853073408,\n" +
                "198710193230757888,\n" +
                "198720423691866112,\n" +
                "198757921688174592,\n" +
                "198767485062004736,\n" +
                "198769246011179008,\n" +
                "198778809179492352,\n" +
                "198779564774965248,\n" +
                "198783339342381056,\n" +
                "198789631410753536,\n" +
                "198808757193719808,\n" +
                "198816809724727296,\n" +
                "198820836579524608,\n" +
                "198829643510628352,\n" +
                "198858333686644736,\n" +
                "198859339002597376,\n" +
                "198865128681422848,\n" +
                "199072062772658176,\n" +
                "199072080174825472,\n" +
                "199072086638252032,\n" +
                "199072087640686592,\n" +
                "199072101561581568,\n" +
                "199072107441995776,\n" +
                "199072205219614720,\n" +
                "199072213398507520,\n" +
                "199072216342908928,\n" +
                "199072271284097024,\n" +
                "199072275834916864,\n" +
                "199072301814435840,\n" +
                "199072306235232256,\n" +
                "199072419259142144,\n" +
                "199072650566619136,\n" +
                "199072662608461824,\n" +
                "199072705528774656,\n" +
                "199072716765315072,\n" +
                "199072729297899520,\n" +
                "199072782427144192,\n" +
                "199072807471333376,\n" +
                "199072826580582400,\n" +
                "199095647318884352,\n" +
                "199117037581422592,\n" +
                "199153275986300928,\n" +
                "199158309499224064,\n" +
                "199158309981569024,\n" +
                "199174415622393856,\n" +
                "199186747530461184,\n" +
                "199194800824827904,\n" +
                "199222231396827136,\n" +
                "199228270368309248,\n" +
                "199235318166372352,\n" +
                "199236576067506176,\n" +
                "199434413124407296,\n" +
                "199434416257552384,\n" +
                "199434427175321600,\n" +
                "199434434397917184,\n" +
                "199434437958877184,\n" +
                "199434450822807552,\n" +
                "199434474495459328,\n" +
                "199434481629974528,\n" +
                "199434490119241728,\n" +
                "199434517759709184,\n" +
                "199434523505905664,\n" +
                "199434551737765888,\n" +
                "199434557991469056,\n" +
                "199434577104916480,\n" +
                "199434577918611456,\n" +
                "199434580703625216,\n" +
                "199434581882224640,\n" +
                "199434600664317952,\n" +
                "199434601377349632,\n" +
                "199434605659734016,\n" +
                "199434610831310848,\n" +
                "199434637754552320,\n" +
                "199434654745677824,\n" +
                "199434679227826176,\n" +
                "199434680364482560,\n" +
                "199434681253675008,\n" +
                "199434685531865088,\n" +
                "199434729802743808,\n" +
                "199434734173208576,\n" +
                "199434749801189376,\n" +
                "199434802091573248,\n" +
                "199435018010148864,\n" +
                "199435045168267264,\n" +
                "199446457873645568,\n" +
                "JD198709763922776064,\n" +
                "JD198709789923262464,\n" +
                "JD198745340059631616,\n" +
                "JD198794160642510848,\n" +
                "JD199072023698522112,\n" +
                "JD199072068128784384,\n" +
                "JD199072650159771648,\n" +
                "JD199072855642914816,\n" +
                "JD199083315041714176,\n" +
                "JD199120813348409344,\n" +
                "JD199183225434980352,\n" +
                "JD199213423291318272,\n" +
                "JD199213423563948032,\n" +
                "JD199230787902816256,\n" +
                "JD199233052957003776,\n" +
                "JD199233053179301888,\n" +
                "JD199434581236301824,\n" +
                "JD199434586479185920,\n" +
                "JD199434688329469952,\n" +
                "JD199435034258886656";
    }
    @DisplayName("测试转仓")
    @Test
    public void testChangeWarehouse(){
        String url = "https://store.gotozhangsanlisi.com/api/internal/v1.0/wmsLogisticsOrder/submit";
        String[] split = logisticsOrderNo.replaceAll("\n", "").split(",");

        ArrayList<String> list = Lists.newArrayList(split);
        List<List<String>> partition = Lists.partition(list, 2);
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
