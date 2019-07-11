package com.springbootjson.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.springbootjson.pojo.User;

import java.io.IOException;

/**
 * @Author: czw
 * @CreateTime: 2019-07-11 09:31
 * @UpdeteTime: 2019-07-11 09:31
 * @Description:
 */
public class UserDeserializer extends JsonDeserializer<User> {
	@Override
	public User deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {
		JsonNode node=jsonParser.getCodec().readTree(jsonParser);
		String name=node.get("name").asText();
		User user=new User();
		user.setName(name);
		return user;
	}
}
