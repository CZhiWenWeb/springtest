package com.czw.code.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

/**
 * @Author: czw
 * @CreateTime: 2019-09-23 10:10
 * @UpdeteTime: 2019-09-23 10:10
 * @Description:
 */
@Data
@Component
public class SecurityProperties {
	//验证码设置
	private CaptchaProperties captcha = new CaptchaProperties();
	//浏览器配置
	private BrowserProperties browser = new BrowserProperties();

	@Data
	public static class BrowserProperties {
		//登入页配置
		private String loginPage = "/login";
		//登录处理url
		private String loginProcessUrl = "/user/login";
		//注册页配置
		private String sigUpUrl = "/signUpUrl";
		//登入方式
		private LoginType loginType = LoginType.JSON;
		//token过期时间
		private Integer rememberMeSeconds = 3600;
	}

	/**
	 * 所有图形验证码的配置属性,
	 * 包括图形验证码和短信验证码
	 */
	@Data
	public static class CaptchaProperties {

		private ImageCaptchaProperties image = new ImageCaptchaProperties();
		private SmsCaptchaProperties sms = new SmsCaptchaProperties();

		/**
		 * 图形验证码配置属性
		 */
		@Data
		@EqualsAndHashCode(callSuper = false)
		public static class ImageCaptchaProperties extends SmsCaptchaProperties {
			private Integer width = 67;
			private Integer height = 23;

			//这样在继承后也可以修改length的默认值,而不会和短信验证码的发生长度冲突
			public ImageCaptchaProperties() {
				setLength(4);
			}
		}

		/**
		 * 短信验证码配置属性
		 */
		@Data
		private static class SmsCaptchaProperties {
			//验证码长度
			protected Integer length = 4;
			//过期时间
			protected Integer expireSecond = 60;
			//需要手机验证的url
			protected String url = "";
		}
	}
}
