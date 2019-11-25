package com.fanhanfei.common;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ThirdPartyApplication.class })
@Slf4j
public class SkuStockTest {

    @Before
    public void BeforeTest(){
        log.info("测试前初始化……");
        HttpClient.COOKIE_STR="_ga=GA1.2.1065160545.1536546797; x-app-platform=other; x-app-platform.sig=RG5xQ_7Lg1bs09ZKRMDB0arbnvY; x-user-id.sig=8D0ZvX9TcTs5K0jTfjstU20vpcI; x-user-id=; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2256f615b988ee97882b7e953c%22%2C%22%24device_id%22%3A%22165c1537765319-0a573bfe272fa7-34647908-1024000-165c1537766872%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22%22%2C%22%24latest_referrer_host%22%3A%22%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_utm_source%22%3A%22moment%22%2C%22%24latest_utm_medium%22%3A%22web%22%2C%22%24latest_utm_campaign%22%3A%22client_share%22%2C%22%24latest_utm_content%22%3A%22topic%22%7D%2C%22first_id%22%3A%22165c1537765319-0a573bfe272fa7-34647908-1024000-165c1537766872%22%7D; sreAuth=Bearer%20eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InpoYW5nanVuc2h1YWkiLCJleHAiOjE1NzIzMTYwMDF9.Zi8Ioqjg9xDCr1I4mHaN6zjFPILMRSYq5XS9vsKl3d8; preLdapAuth=Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiemhhbmdqdW5zaHVhaSIsImlhdCI6MTU3MjI2MTkyNywiZXhwIjoxNTc0ODUzOTI3fQ.Ota_ftj6WC1tG9j_pP0jsQTKfSkFL4pl5OWWQAwHfg0; onlineLdapAuth=Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiemhhbmdqdW5zaHVhaSIsImlhdCI6MTU3MjMxNTg4OSwiZXhwIjoxNTc0OTA3ODg5fQ.Jlmf-KZAiYiFyUPXFE5QtY7EX5XSZqlihQDq1eEf3Vc; authorization=Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiemhhbmdqdW5zaHVhaSIsImlhdCI6MTU3MjMxNTg4OSwiZXhwIjoxNTc0OTA3ODg5fQ.Jlmf-KZAiYiFyUPXFE5QtY7EX5XSZqlihQDq1eEf3Vc; x-request-id=1edbad6c2e4061e1a867eb99adc2495d; x-request-id.sig=ZqhoiZwTP36g6nDDay47U1KudW8; JSESSIONID=40A6AF0B26C7F586995DAC7DBF1264AB";
        HttpClient.CONTENT_TYPE="application/x-www-form-urlencoded; charset=UTF-8";
        log.info("测试前初始化……end");
    }
    @Test
    public void changeDefective(){
        log.info("开始测试");
        String url="https://erp.gotokeep.com/skuSales/changeDefectiveStock";
        String basePath="/Users/zhangjunshuai/库存差异查询/残品/";
        String readName ="残品天猫上海.csv";
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
                String fileName = "/Users/zhangjunshuai/库存差异查询/北京仓虚拟差执行结果"+System.currentTimeMillis()+".txt";
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
