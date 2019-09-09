package com.example.demo.properties;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author: czw
 * @CreateTime: 2019-09-04 09:14
 * @UpdeteTime: 2019-09-04 09:14
 * @Description:
 */
@Data
@Component
public class SecurityProperties {
	//验证码设置
	private CaptchaProperties captcha=new CaptchaProperties();
	//浏览器配置
	private BrowserProperties browser=new BrowserProperties();
	/**
	 * 验证码
	 */
	@Data
	public static class CaptchaProperties{
		private ImageCaptchaProperties image=new ImageCaptchaProperties();
		@Data
		public static class ImageCaptchaProperties{
			private Integer width=67;
			private Integer height=23;
			private Integer length=4;
			private Integer expireSecond=60;
			//需要手机验证的url
			protected String url = "";
		}
	}

	/**
	 * browser配置属性
	 */
	@Data
	public static class BrowserProperties{
		/**
		 * 登入默认配置
		 */
		private String loginPage="/login";
		/**
		 * 记住我的时间
		 */
		private int rememberMeSeconds=3600;
	}
}
