package com.springbootjson.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootjson.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-07-11 09:36
 * @UpdeteTime: 2019-07-11 09:36
 * @Description:
 */
@RestController
public class JacksonController {
	@Autowired
	ObjectMapper mapper;

	@JsonView(User.UserNameView.class)
	@RequestMapping("getUser")
	public User getUer(){
		User user=new User();
		user.setName("mrbird");
		user.setAge(24);
		user.setPassword("123456");
		user.setBirthday(LocalDate.now());
		return user;
	}

	@RequestMapping("serialization")
	public String serialization(){
		try{
			User user=new User();
			user.setName("mrbird");
			user.setBirthday(LocalDate.now());
			return mapper.writeValueAsString(user);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("readjsonstring")
	public String readJsonString(){
		try{
			String json="{\"name\":\"mrbird\",\"age\":26}";
			JsonNode node=this.mapper.readTree(json);
			String name=node.get("name").asText();
			int age=node.get("age").asInt();
			return name+" "+age;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("customize")
	public String customize() throws IOException {
		String jsonStr="[{\"n\":\"mrbird\",\"age\":26},{\"n\":\"scott\",\"age\":27}]";
		JavaType type=mapper.getTypeFactory().constructParametricType(List.class,User.class);
		List<User> list=mapper.readValue(jsonStr,type);
		String msg="";
		for (User user:list){
			msg+=user.getName();
		}
		return msg;
	}
}
