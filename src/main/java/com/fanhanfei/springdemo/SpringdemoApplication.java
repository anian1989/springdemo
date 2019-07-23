package com.fanhanfei.springdemo;

import com.fanhanfei.springdemo.event.contextrefreshedevent.AppApplicationListener;
import com.fanhanfei.springdemo.event.contextrefreshedevent.userDefined.CustomEventPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author zhangjunshuai
 */
@SpringBootApplication(scanBasePackages = "com.fanhanfei.springdemo", exclude = {RedisAutoConfiguration.class,
		MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@ImportResource("classpath*:beans.xml")
@EnableAsync
public class SpringdemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run =
				SpringApplication.run(SpringdemoApplication.class, args);

		CustomEventPublisher bean = run.getBean(CustomEventPublisher.class);
		bean.publish();

	}
	@Bean
	public AppApplicationListener appApplicationListener(){
		return new AppApplicationListener();
	}

}
