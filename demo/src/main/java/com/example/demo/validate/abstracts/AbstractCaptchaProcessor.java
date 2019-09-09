package com.example.demo.validate.abstracts;

import com.example.demo.validate.CaptchaRepository;
import com.example.demo.validate.image.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: czw
 * @CreateTime: 2019-09-04 09:26
 * @UpdeteTime: 2019-09-04 09:26
 * @Description:
 */
public abstract class AbstractCaptchaProcessor<C extends Captcha> implements CaptchaProcessor{
	@Autowired
	private CaptchaRepository captchaRepository;
	//session策略
	private SessionStrategy sessionStrategy=new HttpSessionSessionStrategy();
	@Autowired
	private CaptchaGenerator captchaGenerator;
	@Override
	public void process(String type, ServletWebRequest request) throws Exception {
		//创建验证码
		C captcha= create(request);
		//保存验证码
		save(request,captcha);
		//最终处理验证码
		processl(request,captcha);
	}
//	创建
	private C create(ServletWebRequest request){
		return (C) captchaGenerator.createCaptcha(request);
	}
//	保存
	private void save(ServletWebRequest request,Captcha captcha){
		/**
		 * 此处的转换是因为
		 * 该验证码需要存入session,而session需要存入redis.
		 * 而存入redis的所有对象包括对象中的属性对象都需要实现序列化接口.
		 * 而如果是图形验证码,则会有一个 图片流 对象没有实现序列化,抛弃他生成新的只有code和过期时间的对象即可
		 */
		//Captcha captcha1=new Captcha(captcha.getCode(),captcha.getExpireTime());
		//调用不同的存储实现类存储   redis
		//captchaRepository.put(request,SESSION_CAPTCHA_PRE,captcha);
		//session存储
		captchaRepository.put(request,SESSION_CAPTCHA_PRE,captcha);
	}
	//最终处理
	protected abstract void processl(ServletWebRequest request,C captcha)throws  Exception;
}
