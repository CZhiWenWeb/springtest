package com.czw.code.validate.code.abstracts;

import com.czw.code.validate.code.sms.Captcha;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: czw
 * @CreateTime: 2019-09-23 10:27
 * @UpdeteTime: 2019-09-23 10:27
 * @Description:验证码生成器
 */
public interface CaptchaGenerator<T extends Captcha> {
	T createCaptcha(ServletWebRequest request);
}
