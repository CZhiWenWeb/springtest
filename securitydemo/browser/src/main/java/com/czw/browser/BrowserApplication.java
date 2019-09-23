package com.czw.browser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.czw.browser.data.mapper")
@SpringBootApplication(scanBasePackages = {"com.czw"})
public class BrowserApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrowserApplication.class, args);
	}

}
