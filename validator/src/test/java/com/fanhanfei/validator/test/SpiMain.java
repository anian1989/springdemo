package com.fanhanfei.validator.test;

import com.alibaba.fastjson.JSONObject;
import com.fanhanfei.spi.IMyServiceProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.spi.ValidationProvider;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author zhangjunshuai
 * @date 2020/3/3
 * @description
 **/
@DisplayName("SPI测试")
public class SpiMain {


    @DisplayName("simpleTest")
    @Test
    public void spiTest(){
        ServiceLoader<IMyServiceProvider> load = ServiceLoader.load(IMyServiceProvider.class);
        Iterator<IMyServiceProvider> iterator = load.iterator();
        while (iterator.hasNext()) {
            IMyServiceProvider next = iterator.next();
            List<String> testList = next.getAll("测试开始");
            System.out.println(JSONObject.toJSONString(testList));

        }


        ServiceLoader<ValidationProvider> load1 = ServiceLoader.load(ValidationProvider.class);
        Iterator<ValidationProvider> iterator1 = load1.iterator();
        while (iterator1.hasNext()){
            ValidationProvider next = iterator1.next();
            System.out.println(next.getClass().getName());
        }
    }
}
