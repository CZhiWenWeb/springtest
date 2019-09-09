package com.example.demo.validate.abstracts;

import com.example.demo.validate.image.Captcha;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: czw
 * @CreateTime: 2019-09-04 09:09
 * @UpdeteTime: 2019-09-04 09:09
 * @Description:
 */
public interface CaptchaGenerator<T extends Captcha> {
	T createCaptcha(ServletWebRequest request);
}
