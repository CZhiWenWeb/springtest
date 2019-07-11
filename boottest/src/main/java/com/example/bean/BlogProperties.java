package com.example.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: czw
 * @CreateTime: 2019-07-02 15:54
 * @UpdeteTime: 2019-07-02 15:54
 * @Description:
 */
@Component
@Data
public class BlogProperties {
	@Value("${my.blog.name}")
	private String name;
	@Value("${my.blog.title}")
	private String title;
}
