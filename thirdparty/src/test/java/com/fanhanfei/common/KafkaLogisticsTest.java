package com.fanhanfei.common;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Before;
import org.joda.time.DateTime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author zhangjunshuai
 * @date 2019/11/9
 * @description
 **/
@Slf4j
public class KafkaLogisticsTest extends BaseTest {
    @BeforeAll
    public static void BeforeTest() {
        log.info("测试前初始化……");
        HttpClient.COOKIE_STR = "_ga=GA1.2.1065160545.1536546797; x-app-platform=other; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2256f615b988ee97882b7e953c%22%2C%22%24device_id%22%3A%22165c1537765319-0a573bfe272fa7-34647908-1024000-165c1537766872%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22%22%2C%22%24latest_referrer_host%22%3A%22%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_utm_source%22%3A%22moment%22%2C%22%24latest_utm_medium%22%3A%22web%22%2C%22%24latest_utm_campaign%22%3A%22client_share%22%2C%22%24latest_utm_content%22%3A%22topic%22%7D%2C%22first_id%22%3A%22165c1537765319-0a573bfe272fa7-34647908-1024000-165c1537766872%22%7D; sreAuth=Bearer%20eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InpoYW5nanVuc2h1YWkiLCJleHAiOjE1NzQwMDYyMDJ9.0dt4O1R7_5kdRFmF9JFPv-BGIR51MK73WdIl0_5_6YE; onlineLdapAuth=Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJnaXZlbm5hbWUiOiIlRTUlQkMlQTAlRTQlQkYlOEElRTUlQjglODUiLCJuYW1lIjoiemhhbmdqdW5zaHVhaSIsImlhdCI6MTU4NTUzNjY1MSwiZXhwIjoxNTg4MTI4NjUxfQ.Du7VPHQr9bh9sapMRkLu-4HfeFiXLOEHavOvzJ8txAM; preLdapAuth=Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJnaXZlbm5hbWUiOiIlRTUlQkMlQTAlRTQlQkYlOEElRTUlQjglODUiLCJuYW1lIjoiemhhbmdqdW5zaHVhaSIsImlhdCI6MTU4NTg4Mzk1MywiZXhwIjoxNTg4NDc1OTUzfQ.XbyGDNH7Fd_sNGGGHmPpOIWBHLetyXSdupnDvqUelfs; x-os=macOS; _gid=GA1.2.202063238.1587353745; x-os.sig=u_ahS2Y6Ihd0B8_OqaBwexiyv1I; x-request-id=af406326eb51b588c8a6031c9d0fad9c; x-request-id.sig=VrQ3a7M5ITyWoR0iYWcjlNd_ovQ; x-app-platform.sig=bAIuUewKc9j9oIn5-Od2B4pQKCk";
        HttpClient.CONTENT_TYPE = "application/x-www-form-urlencoded; charset=UTF-8";
        log.info("测试前初始化……end");
    }

    /**
     * 发送物流订阅
     */
    @Test
    public void test() {
        log.info("开始");
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> objects = Lists.newArrayList();
        String url = "https://kafka.sre.gotozhangsanlisi.com/clusters/mo-kafka/topics/mo_wms_logistics_order_status_change/sendMessage";
        try {
            List<String> contentFromCsv = FileReadUtils.getContentFromCsv("/Users/zhangjunshuai/kafka/offset.txt");
            contentFromCsv.forEach(kk -> {
                if (kk.startsWith("{\"companyCode") || kk.startsWith("{\"billCode")) {
                    kk.replaceAll("\\\\", "");
                    stringBuilder.append(kk);
                    stringBuilder.append("\n");
                    objects.add(kk);
                }

            });
            this.send(objects, url);
        } catch (Exception e) {
            log.error("失败", e);
        } finally {
            DateTime now = DateTime.now();
            String fileName = "/Users/zhangjunshuai/kafka/结果2019年11月09日.txt";
            File file = new File(fileName);
            try {
                Files.write(stringBuilder.toString(), file, Charsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void cancletest() {
        log.info("开始");
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> objects = Lists.newArrayList();
        //取消发货单
        String url = "https://kafka.sre.gotozhangsanlisi.com/clusters/mo-kafka/topics/mo_wms_logistics_order_operate/sendMessage";
        try {
            List<String> contentFromCsv = FileReadUtils.getContentFromCsv("/Users/zhangjunshuai/kafka/offsetcancle.txt");
            contentFromCsv.forEach(kk -> {
                String temp = "{\"context\":{},\"operationType\":2,\"orderNo\":\"" + kk + "\",\"timestamp\":1573442417882}";
                objects.add(temp);

            });
            this.send(objects, url);
        } catch (Exception e) {
            log.error("失败", e);
        } finally {
            DateTime now = DateTime.now();
            String fileName = "/Users/zhangjunshuai/kafka/结果2019年11月09日1.txt";
            File file = new File(fileName);
            try {
                Files.write(stringBuilder.toString(), file, Charsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void sendToWms() {
        log.info("开始");
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> objects = Lists.newArrayList();
        //取消发货单
        String url = "https://kafka.sre.gotozhangsanlisi.com/clusters/mo-kafka/topics/mo_wms_out_bound_order_callback_operation/sendMessage";
        try {
            List<String> contentFromCsv = FileReadUtils.getContentFromCsv("/Users/zhangjunshuai/kafka/logisticsmsg.txt");
            contentFromCsv.forEach(kk -> {
                objects.add(kk);

            });
            this.send(objects, url);
        } catch (Exception e) {
            log.error("失败", e);
        } finally {
            DateTime now = DateTime.now();
            String string = now.toString("yyyy年MM月dd日 HH:mm:ss", Locale.CHINESE);
            String fileName = "/Users/zhangjunshuai/kafka/结果"+string+".txt";
            File file = new File(fileName);
            try {
                Files.write(stringBuilder.toString(), file, Charsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void send(List<String> contentFromCsv, String url) {


//        List<String> contentFromCsv = FileReadUtils.getContentFromCsv("/Users/zhangjunshuai/kafka/结果2019年11月09日.txt");
        if (CollectionUtils.isNotEmpty(contentFromCsv)) {
            for (String temp : contentFromCsv) {
                if (StringUtils.isBlank(temp)) {
                    continue;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("partition=0");
                stringBuilder.append("&&message=").append(temp);
                String postParam = stringBuilder.toString();
                try {
                    HttpClient.sendPost(url, postParam);
                    System.out.println(temp);
                    Thread.sleep(100L);
                } catch (Exception e) {
                    log.error("调用接口异常", e);
                }
            }
        }
    }


}

