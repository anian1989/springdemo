package com.fanhanfei.common;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import org.apache.commons.collections4.CollectionUtils;
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
 * @date 2019/9/29
 * @description
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ThirdPartyApplication.class })
public class ErpTest {
    @Test
    public void changeStock(){
        HttpClient.COOKIE_STR="_ga=GA1.2.1065160545.1536546797; x-app-platform=other; x-app-platform.sig=RG5xQ_7Lg1bs09ZKRMDB0arbnvY; x-user-id.sig=8D0ZvX9TcTs5K0jTfjstU20vpcI; utm_source=moment; utm_medium=web; utm_campaign=client_share; utm_content=topic; x-user-id=; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2256f615b988ee97882b7e953c%22%2C%22%24device_id%22%3A%22165c1537765319-0a573bfe272fa7-34647908-1024000-165c1537766872%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fkeep.com%2Fapp%3Ft%3D____%22%2C%22%24latest_referrer_host%22%3A%22keep.com%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_utm_source%22%3A%22moment%22%2C%22%24latest_utm_medium%22%3A%22web%22%2C%22%24latest_utm_campaign%22%3A%22client_share%22%2C%22%24latest_utm_content%22%3A%22topic%22%7D%2C%22first_id%22%3A%22165c1537765319-0a573bfe272fa7-34647908-1024000-165c1537766872%22%7D; JSESSIONID=6D199B33C8C2FCB935B7701DC4647851; onlineLdapAuth=Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiemhhbmdqdW5zaHVhaSIsImlhdCI6MTU2OTU2ODQ3MCwiZXhwIjoxNTcyMTYwNDcwfQ.xllPcqO6Pg4D3eEGix5d_e8Wqsp5ldTza9W58tDA-XQ; authorization=Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiemhhbmdqdW5zaHVhaSIsImlhdCI6MTU2OTU2ODQ3MCwiZXhwIjoxNTcyMTYwNDcwfQ.xllPcqO6Pg4D3eEGix5d_e8Wqsp5ldTza9W58tDA-XQ; x-request-id=06da5373b7caad4bc8415a46fd426379; x-request-id.sig=SBmMBGjtCyrDoJKN1BptkWyB6ek";
//        String s = sendGet(url);
        HttpClient.CONTENT_TYPE="application/x-www-form-urlencoded; charset=UTF-8";

        String testFilePath = "/Users/zhangjunshuai/库存差异查询/北京导出20190930.csv";
        File testFile = new File(testFilePath);
        List<String> lines = null;
        try {
            lines = com.google.common.io.Files.readLines(testFile, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (CollectionUtils.isNotEmpty(lines)) {
            ArrayList<String> successList = Lists.newArrayList();
            ArrayList<String> failList = Lists.newArrayList();
            try {
                for (String line : lines) {
                    //skuid,warehouseid,skucode,数值
                    String[] split = line.replaceAll("\"","").split(",");
                    String url="https://erp.pre.gotokeep.com/product/updateStock/"+split[0];
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("physical_ware_list=").append(split[1]);
                    int changNum = Integer.parseInt(split[3]);

                    if(changNum >0){
                        stringBuilder.append("&edit_stock_num=").append(split[3]);
                        stringBuilder.append("&sku_stock_op=").append("inc");
                    }
                    if(changNum<0){
                        stringBuilder.append("&edit_stock_num=").append(changNum*-1);
                        stringBuilder.append("&sku_stock_op=").append("dec");
                    }
                    stringBuilder.append("&reason=%E5%A2%9E%E5%8A%A0%E5%BA%93%E5%AD%98&remark=%E6%89%B9%E9%87%8F%E8%B0%83%E6%95%B4");
                    String postParam=stringBuilder.toString();
                    String s = null;
                    try {
                        s = HttpClient.sendPost(url,postParam);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Map map = JSONObject.parseObject(s, Map.class);
                    Boolean status = (Boolean)map.get("status");
                    map.put("skuId",split[0]);
                    map.put("skuCode",split[2]);
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
                String fileName = "/Users/zhangjunshuai/库存差异查询/北京执行结果"+System.currentTimeMillis()+".txt";
                File file = new File(fileName);
                //还需处理路径不存在的问题
                try {
                    Files.write(stringBuilder.toString(), file, Charsets.UTF_8);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else {
            System.out.println("文件内容是空");
        }
    }
}
