package com.springdb.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class
})
@EnableTransactionManagement
public class DBRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DBRepositoryApplication.class, args);
	}

}
