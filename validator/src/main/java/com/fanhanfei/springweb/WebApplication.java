package com.fanhanfei.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zhangjunshuai
 * @date 2020/2/17
 * @description
 **/
@SpringBootApplication(scanBasePackages = {"com.fanhanfei"}, exclude = {
        DataSourceAutoConfiguration.class,
        MongoAutoConfiguration.class,
        MongoRepositoriesAutoConfiguration.class,
        MongoDataAutoConfiguration.class,
        RabbitAutoConfiguration.class})

@EnableAspectJAutoProxy(proxyTargetClass = true)
//@MapperScan(basePackages = {"","", "", ""})
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WebApplication.class);
        app.setRegisterShutdownHook(false);
        app.run(args);
    }
}
