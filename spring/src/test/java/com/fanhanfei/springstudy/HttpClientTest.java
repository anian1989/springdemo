package com.fanhanfei.springstudy;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * @author zhangjunshuai
 * @date 2019/4/11
 * @description
 **/
@Slf4j
public class HttpClientTest {

    public static  void  main(String[] arg){
        String url="http://10.2.3.252:8089/k3cloud/Kingdee.BOS.ServiceFacade.ServicesStub.DynamicForm.DynamicFormService.Call.common.kdsvc";
        Gson gson = new Gson();
        String requestBody="{\"ap0\":\"ListService\",\"ap1\":\"25558df9-8fb6-43d0-bd20-3180cd37c812\",\"ap2\":\"ToolBarItemClick\",\"ap3\":\"[\\\"FQKFILTERPANEL\\\",\\\"btnSearch\\\",[{\\\"FLIST\\\":{\\\"fieldKey\\\":\\\"SELECTED\\\",\\\"row\\\":0,\\\"selRows\\\":\\\"\\\",\\\"isClientNewRow\\\":false,\\\"clientNewRows\\\":\\\"\\\"}},{\\\"Key\\\":\\\"FQKFILTERPANEL\\\",\\\"Row\\\":0,\\\"Value\\\":\\\"[{\\\\\\\"FieldName\\\\\\\":\\\\\\\"FBillNo\\\\\\\",\\\\\\\"Compare\\\\\\\":\\\\\\\"17\\\\\\\",\\\\\\\"Value\\\\\\\":\\\\\\\"2324234234234\\\\\\\",\\\\\\\"Left\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"Right\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"Logic\\\\\\\":\\\\\\\"0\\\\\\\"},{\\\\\\\"FieldName\\\\\\\":\\\\\\\"FMaterialId.FNumber\\\\\\\",\\\\\\\"Compare\\\\\\\":\\\\\\\"17\\\\\\\",\\\\\\\"Value\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"Left\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"Right\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"Logic\\\\\\\":\\\\\\\"0\\\\\\\"},{\\\\\\\"FieldName\\\\\\\":\\\\\\\"FSupplierId.FName\\\\\\\",\\\\\\\"Compare\\\\\\\":\\\\\\\"17\\\\\\\",\\\\\\\"Value\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"Left\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"Right\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"Logic\\\\\\\":\\\\\\\"0\\\\\\\"}]\\\"}]]\",\"nonce\":\"\",\"v\":\"1.0\",\"format\":\"1\",\"sign\":\"\",\"timestamp\":\"\\\"2019-04-11T05:54:34.976Z\\\"\",\"compressed\":true,\"useragent\":\"KD.HTML5.GZIP\",\"clientinfo\":\"{\\\"ipAddress\\\":\\\"mozila\\\",\\\"macAddress\\\":\\\"browser\\\",\\\"hostName\\\":\\\"mozila\\\",\\\"IsDefaultInfo\\\":true,\\\"IpAddress\\\":\\\"mozila\\\",\\\"MacAddress\\\":\\\"browser\\\",\\\"HostName\\\":\\\"mozila\\\",\\\"Version\\\":\\\"HTML5\\\",\\\"ClientType\\\":16,\\\"vH\\\":946,\\\"vW\\\":1920,\\\"AvailableAreaSize\\\":{\\\"Height\\\":946,\\\"Width\\\":1920},\\\"ScreenSize\\\":{\\\"Height\\\":1080,\\\"Width\\\":1920},\\\"EntryPageUrl\\\":\\\"http://10.2.3.252:8089/k3cloud/html5/dform.aspx?formId=BOS_HtmlConsole&formType=mobileform&pageId=MainPageId&usertoken=3bae4e63-7bf3-4d33-9cd6-e2e8049f584e&kdsid=246e5cb2-3ae3-4330-a7f9-94550015d2cc&custparam=\\\",\\\"customArgs\\\":\\\"\\\"}\"}";
//        KingDeeRequest kingDeeRequest = gson.fromJson(requestBody, KingDeeRequest.class);

        String post = HttpClientTest.post(url, requestBody);
        log.info("返回结果"+post);
    }


    public static String post(String urlNameString, String requestBody) {
        String result = "";
        BasicCookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build();
        try {
            StringEntity entity = new StringEntity(requestBody, "utf-8");//解决中文乱码问题
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");

            HttpPost post = new HttpPost(urlNameString);//这里发送get请求
            post.setEntity(entity);
            BasicClientCookie[] basicClientCookies = new BasicClientCookie[3];
            basicClientCookies[0] = new BasicClientCookie("ASP.NET_SessionId", "3fjq2peo0z0gsaieihvcrp13");
            basicClientCookies[0].setDomain("10.2.3.252");
            basicClientCookies[0].setPath("/");
            basicClientCookies[1] = new BasicClientCookie("Theme", "standard");
            basicClientCookies[1].setDomain("10.2.3.252");
            basicClientCookies[1].setPath("/k3cloud/html5");
            basicClientCookies[2] = new BasicClientCookie("kdservice-sessionid", "246e5cb2-3ae3-4330-a7f9-94550015d2cc");
            basicClientCookies[2].setDomain("10.2.3.252");
            basicClientCookies[2].setPath("/");

            cookieStore.addCookies(basicClientCookies);
            // 通过请求对象获取响应对象
            HttpResponse response = httpClient.execute(post);
            // 判断网络连接状态码是否正常(0--200都数正常)
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
