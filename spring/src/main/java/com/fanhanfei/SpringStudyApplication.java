package com.fanhanfei;

import com.fanhanfei.springstudy.event.contextrefreshedevent.AppApplicationListener;
import com.fanhanfei.springstudy.event.contextrefreshedevent.userDefined.CustomEventPublisher;
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
@SpringBootApplication(scanBasePackages = "com.fanhanfei", exclude = {RedisAutoConfiguration.class,
		MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@ImportResource("classpath*:beans.xml")
@EnableAsync
public class SpringStudyApplication {
	/**
	 * 项目启动配置 --debug 会输出自动配置项
	 * @param args
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext run =
				SpringApplication.run(SpringStudyApplication.class, args);

		CustomEventPublisher bean = run.getBean(CustomEventPublisher.class);
		bean.publish();

	}
	@Bean
	public AppApplicationListener appApplicationListener(){
		return new AppApplicationListener();
	}

}
