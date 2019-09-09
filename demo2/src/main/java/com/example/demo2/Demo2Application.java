package com.example.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
public class Demo2Application {
	@GetMapping("/user")
	public Authentication user(Authentication user, HttpServletRequest request){
		return user;
	}

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

}
