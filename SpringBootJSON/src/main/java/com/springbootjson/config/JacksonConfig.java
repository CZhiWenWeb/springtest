package com.springbootjson.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Author: czw
 * 提供jackson对localDate java8提供的日期的序列化支持
 * @CreateTime: 2019-07-11 09:01
 * @UpdeteTime: 2019-07-11 09:01
 * @Description:
 */
@Configuration
public class JacksonConfig {
	public ObjectMapper getObjectMapper(){
		ObjectMapper mapper=new ObjectMapper();
		//JavaTimeModule javaTimeModule=new JavaTimeModule();
		//javaTimeModule.addSerializer(LocalDate.class,new LocalDateSerializer(DateTimeFormatter
		//.ofPattern("yyyy-MM-dd")));
		//mapper.registerModule(javaTimeModule);
		return mapper;
	}
}
