package com.example.demo.validate;

import com.example.demo.properties.SecurityProperties;
import com.example.demo.validate.abstracts.CaptchaGenerator;
import com.example.demo.validate.image.DefaultImageCaptchaGenerator;
import com.example.demo.validate.image.ImageCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: czw
 * @CreateTime: 2019-09-04 09:45
 * @UpdeteTime: 2019-09-04 09:45
 * @Description:
 */
@Configuration
public class CaptchaBeanConfig {
	@Autowired
	private SecurityProperties securityProperties;

	@Bean
	@ConditionalOnMissingBean(name = "imageCaptchaGenerator")
	public CaptchaGenerator<ImageCaptcha> imageCaptchaGenerator() {
		//创建默认的图片验证码生成器
		DefaultImageCaptchaGenerator imageCaptchaGenerator = new DefaultImageCaptchaGenerator();
		imageCaptchaGenerator.setSecurityProperties(securityProperties);
		return imageCaptchaGenerator;
	}
}
