package com.fanhanfei.common;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhangjunshuai
 * @date 2019/10/30
 * @description
 **/

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { ThirdPartyApplication.class })
@Slf4j
public class SkuStockTest {

    @BeforeAll
    public void BeforeTest(){
        log.info("测试前初始化……");
        HttpClient.COOKIE_STR="_ga=GA1.2.1065160545.1536546797; x-app-platform=other; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2256f615b988ee97882b7e953c%22%2C%22%24device_id%22%3A%22165c1537765319-0a573bfe272fa7-34647908-1024000-165c1537766872%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22%22%2C%22%24latest_referrer_host%22%3A%22%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_utm_source%22%3A%22moment%22%2C%22%24latest_utm_medium%22%3A%22web%22%2C%22%24latest_utm_campaign%22%3A%22client_share%22%2C%22%24latest_utm_content%22%3A%22topic%22%7D%2C%22first_id%22%3A%22165c1537765319-0a573bfe272fa7-34647908-1024000-165c1537766872%22%7D; sreAuth=Bearer%20eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InpoYW5nanVuc2h1YWkiLCJleHAiOjE1NzQwMDYyMDJ9.0dt4O1R7_5kdRFmF9JFPv-BGIR51MK73WdIl0_5_6YE; authorization=Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiemhhbmdqdW5zaHVhaSIsImlhdCI6MTU3ODQ2NjcwOSwiZXhwIjoxNTc4NjM5NTA5fQ.VUlwaK0D91bPImUSOJ7HEp23isek9r8ipkV_Y45xTo4; JSESSIONID=85AB2A413EDC85770E26C319B9D92567; preLdapAuth=Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiemhhbmdqdW5zaHVhaSIsImlhdCI6MTU3ODk4NjU0NiwiZXhwIjoxNTc5MTU5MzQ2fQ.txRztgQdQjS5kLyELywVkMQd-8_VD4ni4RIhuzrxkIY; x-user-id=; x-user-id.sig=8D0ZvX9TcTs5K0jTfjstU20vpcI; x-app-platform.sig=RG5xQ_7Lg1bs09ZKRMDB0arbnvY; onlineLdapAuth=Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiemhhbmdqdW5zaHVhaSIsImlhdCI6MTU3OTQwMzA2NSwiZXhwIjoxNTc5NTc1ODY1fQ.V9hHFXJLkju9w5pX32f5EU2R96KuM07dV_PlXVsUD0M; x-request-id=dfdbb6e3ea3e6b12f558ac35dcbd47ba; x-request-id.sig=SiVpHWEaKyK_NY_oY5h7ByvTrqU";
        HttpClient.CONTENT_TYPE="application/x-www-form-urlencoded; charset=UTF-8";
        log.info("测试前初始化……end");
    }
    @Test
    public void changeDefective(){
        log.info("开始测试");
        String url="https://erp.gotokeep.com/skuSales/changeDefectiveStock";
        String basePath="/Users/zhangjunshuai/库存差异查询/残品/";
        String readName ="残品天猫1.csv";
        String path=basePath+readName;
        List<String> contentFromCsv = FileReadUtils.getContentFromCsv(path);
        if (CollectionUtils.isNotEmpty(contentFromCsv)) {
            ArrayList<String> successList = Lists.newArrayList();
            ArrayList<String> failList = Lists.newArrayList();
            try {
                for (String line : contentFromCsv) {
                    //skuCode,warehouseid,step,channel,defectiveType
                    String[] split = line.replaceAll("\"","").split(",");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("skuCode=").append(split[0]);
                    stringBuilder.append("&warehouseId=").append(split[1]);
                    stringBuilder.append("&step=").append(split[2]);
                    stringBuilder.append("&channel=").append(split[3]);
                    stringBuilder.append("&defectiveType=").append(split[4]);

                    String postParam=stringBuilder.toString();
                    String s = null;
                    try {
                        s = HttpClient.sendPost(url,postParam);
                        log.info("调用接口的结果是:{}",s);
                    } catch (Exception e) {
                        log.error("调用接口异常",e);
                    }
                    //{"object":true,"errorCode":0,"message":null,"success":true}
                    Map map = JSONObject.parseObject(s, Map.class);
                    Boolean status = (Boolean)map.get("object");
                    map.put("skuCode",split[0]);
                    map.put("warehouseId",split[1]);
                    String string = JSONObject.toJSONString(map);
                    if (status){
                        successList.add(string);
                    }else {
                        failList.add(string);
                    }

                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } finally {
                System.out.println("成功");
                StringBuilder stringBuilder = new StringBuilder();
                successList.forEach(s -> {
                    System.out.println(s);
                    stringBuilder.append(s).append("\n");
                });
                System.out.println("失败");
                stringBuilder.append("\n失败\n");
                failList.forEach(s -> {
                    System.out.println(s);
                    stringBuilder.append(s).append("\n");
                });
                String fileName = path.substring(0,path.indexOf("."))+"执行结果"+System.currentTimeMillis()+".txt";
                File file = new File(fileName);
                //还需处理路径不存在的问题
                try {
                    Files.write(stringBuilder.toString(), file, Charsets.UTF_8);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else {
            log.error("文件内容是空");
        }
    }


    @Test
    public void changeKeepStock(){
        log.info("开始测试");
        String url="https://erp.gotokeep.com/skuSales/changeKeepStock";
        String path="/Users/zhangjunshuai/库存差异查询/良品/11月北京差异1.csv";
        Integer changeType =0;//1 实际 2 虚拟 0全部
        List<String> contentFromCsv = FileReadUtils.getContentFromCsv(path);
        if (CollectionUtils.isNotEmpty(contentFromCsv)) {
            ArrayList<String> successList = Lists.newArrayList();
            ArrayList<String> failList = Lists.newArrayList();
            try {
                for (String line : contentFromCsv) {
                    //skuCode,warehouseid,step,channel
                    String[] split = line.replaceAll("\"","").split(",");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("skuCode=").append(split[0]);
                    stringBuilder.append("&warehouseId=").append(split[1]);
                    stringBuilder.append("&step=").append(split[2]);
                    stringBuilder.append("&channel=").append(split[3]);
                    stringBuilder.append("&changeType=").append(changeType);

                    String postParam=stringBuilder.toString();
                    String s = null;
                    try {
                        s = HttpClient.sendPost(url,postParam);
                        log.info("调用接口的结果是:{}",s);
                    } catch (Exception e) {
                        log.error("调用接口异常",e);
                    }
                    //{"object":true,"errorCode":0,"message":null,"success":true}
                    Map map = JSONObject.parseObject(s, Map.class);
                    Boolean status = (Boolean)map.get("object");
                    map.put("skuCode",split[0]);
                    map.put("warehouseId",split[1]);
                    String string = JSONObject.toJSONString(map);
                    log.info("调用接口的结果是:{}",string);
                    if (status){
                        successList.add(string);
                    }else {
                        failList.add(string);
                    }

                }
            } catch (Exception e) {
                log.error("执行接口异常",e);
            } finally {
                System.out.println("成功");
                StringBuilder stringBuilder = new StringBuilder();
                successList.forEach(s -> {
                    System.out.println(s);
                    stringBuilder.append(s).append("\n");
                });
                System.out.println("失败");
                stringBuilder.append("\n失败\n");
                failList.forEach(s -> {
                    System.out.println(s);
                    stringBuilder.append(s).append("\n");
                });
                String fileName = "/Users/zhangjunshuai/库存差异查询/天津良品增加差执行结果"+System.currentTimeMillis()+".txt";
                File file = new File(fileName);
                //还需处理路径不存在的问题
                try {
                    Files.write(stringBuilder.toString(), file, Charsets.UTF_8);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else {
            log.error("文件内容是空");
        }

    }


    /**
     * 渠道调拨
     */
    @Test
    public void transfer(){
        log.info("*********************开始调拨********************");
        String url="https://erp.gotokeep.com/sku/channel/flip";
        String path="/Users/zhangjunshuai/库存差异查询/良品/渠道调拨.csv";
        int updateSkuStockPatternCode = 1;//调拨模式
        List<String> contentFromCsv = FileReadUtils.getContentFromCsv(path);
        if (CollectionUtils.isNotEmpty(contentFromCsv)) {
            ArrayList<String> successList = Lists.newArrayList();
            ArrayList<String> failList = Lists.newArrayList();
            try {
                for (String line : contentFromCsv) {
                    Thread.sleep(1000L);
                    String[] split = line.replaceAll("\"","").split(",");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("skuId=").append(split[0]);
                    stringBuilder.append("&fromChannelId=").append(split[1]);
                    stringBuilder.append("&toChannelId=").append(split[2]);
                    stringBuilder.append("&physicalWareId=").append(split[3]);
                    stringBuilder.append("&busFlag=0");
                    stringBuilder.append("&step=").append(split[4]);
                    stringBuilder.append("&updateSkuStockPatternCode=").append(updateSkuStockPatternCode);

                    String postParam=stringBuilder.toString();
                    String s = null;
                    try {
                        log.info("调用接口的是:{}",postParam);
                        s = HttpClient.sendPost(url,postParam);
                        log.info("调用接口的结果是:{}",s);

                    //{"object":true,"errorCode":0,"message":null,"success":true}
                        Map map = JSONObject.parseObject(s, Map.class);
                        Boolean status = (Boolean)map.get("object");
                        map.put("skuId",split[0]);
                        map.put("physicalWareId",split[3]);
                        String string = JSONObject.toJSONString(map);
                        log.info("调用接口的结果是:{}",string);
                        if (status){
                            successList.add(string);
                        }else {
                            failList.add(string);
                        }
                    } catch (Exception e) {
                        log.error("调用接口异常",e);
                        failList.add(line);
                    }

                }
            } catch (Exception e) {
                log.error("执行接口异常",e);
            } finally {
                System.out.println("成功");
                StringBuilder stringBuilder = new StringBuilder();
                successList.forEach(s -> {
                    System.out.println(s);
                    stringBuilder.append(s).append("\n");
                });
                System.out.println("失败");
                stringBuilder.append("\n失败\n");
                failList.forEach(s -> {
                    System.out.println(s);
                    stringBuilder.append(s).append("\n");
                });
                String fileName = "/Users/zhangjunshuai/库存差异查询/调拨差执行结果"+System.currentTimeMillis()+".txt";
                File file = new File(fileName);
                //还需处理路径不存在的问题
                try {
                    Files.write(stringBuilder.toString(), file, Charsets.UTF_8);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else {
            log.error("文件内容是空");
        }

    }




}
