package com.fanhanfei.springstudy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author zhangjunshuai
 * @date 2019/9/12
 * @description
 **/

public class TempTest {

    /**
     * apiMethodName : taobao.qimen.order.cancel
     * customerId : BL0589
     * orderCode : TM617408064870616766
     * orderType : JYCK
     * ownerCode : BL0589
     * responseClass : com.qimen.api.response.OrderCancelResponse
     * timestamp : 1568102436047
     * version : 2.0
     * warehouseCode : EC_BJ_BXY
     */

    private String apiMethodName;
    private String customerId;
    private String orderCode;
    private String orderType;
    private String ownerCode;
    private String responseClass;
    private long timestamp;
    private String version;
    private String warehouseCode;

    public static void main(String[] args) {
        String temp ="2019-09-11 00:00:04,557 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618341281756923372\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131204445,\"version\":\"2.0\",\"warehouseCode\":\"CLOUD_SH_JIAMIN\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:00:04,678 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618246753095663557\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131204403,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:00:22,723 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618366945570406258\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131222591,\"version\":\"2.0\",\"warehouseCode\":\"CLOUD_SH_JIAMIN\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:00:46,189 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM554811878185309993S0\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131245877,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:00:48,353 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618349985456119648\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131248075,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:00:49,357 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618272064193739940\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131249224,\"version\":\"2.0\",\"warehouseCode\":\"CLOUD_SH_JIAMIN\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:00:51,521 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618439555637207350\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131251407,\"version\":\"2.0\",\"warehouseCode\":\"CLOUD_SH_JIAMIN\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:01:07,788 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618444707159807671\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131267675,\"version\":\"2.0\",\"warehouseCode\":\"CLOUD_SH_JIAMIN\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:01:18,320 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618344353843388834\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131278192,\"version\":\"2.0\",\"warehouseCode\":\"CLOUD_SH_JIAMIN\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:01:18,478 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618365218557751271\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131278194,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:01:19,964 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM557988623817299701\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131279445,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:01:42,734 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618442467162607756\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131302453,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:01:44,568 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM617844992686950250\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131304295,\"version\":\"2.0\",\"warehouseCode\":\"CLOUD_SH_JIAMIN\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:02:42,988 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618325186367745272\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131362687,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:03:45,764 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618362690886934412S1\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131425634,\"version\":\"2.0\",\"warehouseCode\":\"CLOUD_SH_JIAMIN\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:07:20,413 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM554814278503178596\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131640307,\"version\":\"2.0\",\"warehouseCode\":\"CLOUD_SH_JIAMIN\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:07:55,877 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618275360089069168\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131675558,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:08:24,386 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618335202172898080\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131704051,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:08:26,920 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618448163329218787\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131706625,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:08:30,820 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618369025499698759\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131710691,\"version\":\"2.0\",\"warehouseCode\":\"CLOUD_SH_JIAMIN\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:09:25,376 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618012866686922649\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131765043,\"version\":\"2.0\",\"warehouseCode\":\"CLOUD_SH_JIAMIN\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:10:55,260 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM554756772020276293\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131855110,\"version\":\"2.0\",\"warehouseCode\":\"CLOUD_SH_JIAMIN\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:11:02,170 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM554756772020276293\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131862075,\"version\":\"2.0\",\"warehouseCode\":\"CLOUD_SH_JIAMIN\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:11:44,434 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618361378825224341\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131904106,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:11:44,539 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618361378825224341\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131904111,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:11:44,541 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618361378825224341\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131904111,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:11:44,542 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618361378825224341\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568131904109,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:14:27,825 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618229698242104710S1\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568132067677,\"version\":\"2.0\",\"warehouseCode\":\"CLOUD_SH_JIAMIN\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:14:30,969 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618298848813332668\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568132070665,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:16:40,189 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM617153443149177762\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568132199707,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:19:55,508 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM557951246805579201\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568132395226,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:19:55,618 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM557951246805579201\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568132395294,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:29:27,375 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM554791398954188195_1\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568132967045,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:30:48,945 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618085152897697776S0\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568133048638,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:30:48,959 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618085152897697776S1\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568133048638,\"version\":\"2.0\",\"warehouseCode\":\"CLOUD_SH_JIAMIN\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 00:33:49,178 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618443427005808642\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568133228855,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}";
        String temp1="2019-09-11 01:00:37,853 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM617809442850134974S0\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568134837548,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 01:00:37,881 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM617809442850134974S1\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568134837556,\"version\":\"2.0\",\"warehouseCode\":\"CLOUD_SH_JIAMIN\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 01:00:37,961 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM617809442850134974S0\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568134837550,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 01:05:23,190 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618363618508279772\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568135122881,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 01:07:16,738 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM615986080971595710\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568135236347,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 01:09:10,347 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618344672570297344\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568135350202,\"version\":\"2.0\",\"warehouseCode\":\"CLOUD_SH_JIAMIN\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 01:13:57,120 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618416643279660828\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568135636699,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}" +
                "2019-09-11 01:38:15,347 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618351008606775264\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568137095033,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}" +
                "2019-09-11 03:52:20,812 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618488835637840706\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568145140431,\"version\":\"2.0\",\"warehouseCode\":\"EC_BJ_BXY\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}\n" +
                "2019-09-11 04:40:30,097 DEBUG c.k.t.s.r.QimenApiRpc [QimenApiRpc.java:148] 取消发货单成功, request: {\"apiMethodName\":\"taobao.qimen.order.cancel\",\"customerId\":\"BL0589\",\"orderCode\":\"TM618433282774488958\",\"orderType\":\"JYCK\",\"ownerCode\":\"BL0589\",\"responseClass\":\"com.qimen.api.response.OrderCancelResponse\",\"timestamp\":1568148029977,\"version\":\"2.0\",\"warehouseCode\":\"CLOUD_SH_JIAMIN\"}, response: {\"body\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?>\\n<response>\\n    <flag>success</flag>\\n</response>\\n\",\"flag\":\"success\",\"success\":true}";
        String temp2= "";

        String key="2019-09-11";
        String[] split1 = temp.split(key);
        String[] split2 = temp1.split(key);
        String[] split3 = temp2.split(key);
        ArrayList<String> objects = Lists.newArrayList();
        Collections.addAll(objects,split1);
        Collections.addAll(objects,split2);
        Collections.addAll(objects,split3);
        HashSet<String> stringHashSet = new HashSet<>();
        for (String str : objects) {
            if (StringUtils.isNotBlank(str)) {
                int i = str.indexOf("request:") + 8;
                int j = str.indexOf(", response:");
                String substring = str.substring(i, j);
                JSONObject userJson = JSONObject.parseObject(substring);
                TempTest tempTest = JSON.toJavaObject(userJson, TempTest.class);
                stringHashSet.add(tempTest.getOrderCode());
            }

        }

        stringHashSet.forEach(kk->{
            System.out.println(kk);
        });

    }

    public String getApiMethodName() {
        return apiMethodName;
    }

    public void setApiMethodName(String apiMethodName) {
        this.apiMethodName = apiMethodName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getResponseClass() {
        return responseClass;
    }

    public void setResponseClass(String responseClass) {
        this.responseClass = responseClass;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }
}
