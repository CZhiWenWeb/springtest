package com.springbootjson.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.springbootjson.pojo.User;

import java.io.IOException;

/**
 * @Author: czw
 * @CreateTime: 2019-07-11 09:20
 * @UpdeteTime: 2019-07-11 09:20
 * @Description:
 */
public class UserSerializer extends JsonSerializer<User> {
	@Override
	public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("name",user.getName());
		jsonGenerator.writeEndObject();
	}
}
