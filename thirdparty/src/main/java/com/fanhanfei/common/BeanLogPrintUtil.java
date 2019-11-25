package com.fanhanfei.common;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2019/11/1
 * @description
 **/
@Slf4j
public class BeanLogPrintUtil {

    public static void printList(List list){
        if (CollectionUtils.isEmpty(list)) {
            log.error("入参为空");
        }
        list.forEach(kk->log.info(JSONObject.toJSONString(kk)));
    }
}
