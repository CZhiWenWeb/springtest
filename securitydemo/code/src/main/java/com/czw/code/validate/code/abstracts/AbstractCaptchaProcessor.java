package com.czw.code.validate.code.abstracts;

import com.czw.code.validate.CaptchaRepository;
import com.czw.code.validate.code.sms.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;
import java.util.Map;

/**
 * @Author: czw
 * @CreateTime: 2019-09-23 11:03
 * @UpdeteTime: 2019-09-23 11:03
 * @Description:
 */
public abstract class AbstractCaptchaProcessor<C extends Captcha> implements CaptchaProcessor {
	@Autowired
	private CaptchaRepository captchaRepository;
	//session策略
	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	//将该接口的实现类标注为spring管理,spring会自动填充map,String为该接口实现类的类名,接口处为该接口实现类,会放入所有被管理的实现类,若一个
	//实现类都没有被标注会报：required a bean of type 'CaptchaGenerator' that could not be found
	@Autowired
	private Map<String, CaptchaGenerator> captchaGeneratorMap;

	@Override
	public void process(String type, ServletWebRequest request) throws IOException {
		C captcha = create(type, request);
		save(request, captcha);
		endProcess(request, captcha);
	}

	//	创建
	private C create(String type, ServletWebRequest request) {
		return (C) captchaGeneratorMap.get(type + "CaptchaGenerator").createCaptcha(request);
	}

	//	保存
	private void save(ServletWebRequest request, Captcha captcha) {

		//	session存储
		captchaRepository.put(request, SESSION_CAPTCHA_PRE, captcha);
	}

	protected abstract void endProcess(ServletWebRequest request, C captcha) throws IOException;
}
