package com.xyx.security.core.validate.code.abstracts;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: czw
 * @CreateTime: 2019-08-31 14:55
 * @UpdeteTime: 2019-08-31 14:55
 * @Description:验证码处理器
 */
public interface CaptchaProcessor {
//	session前缀
	String SESSION_CAPTCHA_PRE="CAPTCHA_";
	//处理不同类型的验证码
	void process(String type, ServletWebRequest request) throws Exception;
}
