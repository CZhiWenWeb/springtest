package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Author: czw
 * @CreateTime: 2019-07-02 14:35
 * @UpdeteTime: 2019-07-02 14:35
 * @Description:
 */
@SpringBootApplication
@EnableCaching
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
	}
}
