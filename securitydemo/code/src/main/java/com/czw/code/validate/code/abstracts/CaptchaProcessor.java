package com.czw.code.validate.code.abstracts;

import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;

/**
 * @Author: czw
 * @CreateTime: 2019-09-23 10:35
 * @UpdeteTime: 2019-09-23 10:35
 * @Description:验证码处理器
 */
public interface CaptchaProcessor {
	//session前缀
	String SESSION_CAPTCHA_PRE = "CAPTCHA_";

	//	处理不同类型的验证码
	void process(String type, ServletWebRequest request) throws IOException;
}
