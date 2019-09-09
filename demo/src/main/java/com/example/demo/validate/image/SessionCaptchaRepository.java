package com.example.demo.validate.image;

import com.example.demo.validate.CaptchaRepository;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: czw
 * @CreateTime: 2019-09-04 09:49
 * @UpdeteTime: 2019-09-04 09:49
 * @Description:使用sessionStrategy保存captcha
 */
@Component
public class SessionCaptchaRepository implements CaptchaRepository {
	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	@Override
	public void put(ServletWebRequest request, String key, Captcha captcha) {
		sessionStrategy.setAttribute(request,key,captcha);
	}

	@Override
	public Captcha get(ServletWebRequest request, String key) {
		return (Captcha)sessionStrategy.getAttribute(request, key);
	}

	@Override
	public void remove(ServletWebRequest request, String key) {
		sessionStrategy.removeAttribute(request,key);
	}
}