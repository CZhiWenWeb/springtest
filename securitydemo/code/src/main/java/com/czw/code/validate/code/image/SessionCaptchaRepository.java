package com.czw.code.validate.code.image;

import com.czw.code.validate.CaptchaRepository;
import com.czw.code.validate.code.sms.Captcha;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: czw
 * @CreateTime: 2019-09-23 11:08
 * @UpdeteTime: 2019-09-23 11:08
 * @Description:使用sessionStrategy保存captcha
 */
@Component
public class SessionCaptchaRepository implements CaptchaRepository {
	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

	@Override
	public void put(ServletWebRequest request, String key, Captcha captcha) {
		sessionStrategy.setAttribute(request, key, captcha);
	}

	@Override
	public Captcha get(ServletWebRequest request, String key) {
		return (Captcha) sessionStrategy.getAttribute(request, key);
	}

	@Override
	public void remove(ServletWebRequest request, String key) {
		sessionStrategy.removeAttribute(request, key);
	}
}
