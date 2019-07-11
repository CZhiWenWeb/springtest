package com.example.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: czw
 * @CreateTime: 2019-07-02 16:28
 * @UpdeteTime: 2019-07-02 16:28
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "my.blog")
@Data
public class ConfigBean {
	private String name;
	private String title;
	private String wholeTitle;
}
