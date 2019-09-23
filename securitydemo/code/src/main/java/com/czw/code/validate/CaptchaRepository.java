package com.czw.code.validate;

import com.czw.code.validate.code.sms.Captcha;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: czw
 * @CreateTime: 2019-09-23 11:06
 * @UpdeteTime: 2019-09-23 11:06
 * @Description:
 */
public interface CaptchaRepository {
	//保存
	void put(ServletWebRequest request, String key, Captcha captcha);

	//获取
	Captcha get(ServletWebRequest request, String key);

	//删除
	void remove(ServletWebRequest request, String key);
}
