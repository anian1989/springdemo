package com.fanhanfei.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangjunshuai
 * @date 2019/10/1
 * @description
 **/
@SpringBootApplication
//@MapperScan("com.springdb.demo.mapper")
public class ThirdPartyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThirdPartyApplication.class, args);
    }

}
