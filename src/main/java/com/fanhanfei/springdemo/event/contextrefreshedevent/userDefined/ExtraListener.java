package com.fanhanfei.springdemo.event.contextrefreshedevent.userDefined;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zhangjunshuai
 * @date 2019/7/23
 * @description
 **/
@Slf4j
@Component
public class ExtraListener implements ApplicationListener<CustomerEvnet> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(CustomerEvnet event) {
        log.info("ApplicationListener 观察者 2 ===============：{}", JSON.toJSONString(event));
    }
}
