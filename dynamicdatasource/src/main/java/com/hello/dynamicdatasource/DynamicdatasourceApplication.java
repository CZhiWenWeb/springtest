package com.hello.dynamicdatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.hello.dynamicdatasource.mappers")
public class DynamicdatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicdatasourceApplication.class, args);
	}

}
