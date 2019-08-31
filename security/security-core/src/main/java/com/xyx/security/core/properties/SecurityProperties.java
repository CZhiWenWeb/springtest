package com.xyx.security.core.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-08-31 13:38
 * @UpdeteTime: 2019-08-31 13:38
 * @Description:安全配置属性
 */
@Data
@ConfigurationProperties(prefix = "zx.security")
public class SecurityProperties {
//	浏览器配置
	private BrowserProperties browser=new BrowserProperties();
	//验证码相关配置
	private CaptchaProperties captcha=new CaptchaProperties();
	//social配置
	private SocialProperties social=new SocialProperties();
	//oauth2相关配置
	private Oauth2Properties oauth2=new Oauth2Properties();
	/**
	 * browser配置属性
	 */
	@Data
	public static class BrowserProperties{
		//登入配置-默认值
		private String loginPage="/login.html";
		//注册页面配置
		private String signUpUrl="/signUpUrl.html";
		//登入方式，登入成功后，重定向或是返回json
		private LoginType loginType=LoginType.JSON;
		//token过期时间，秒
		private Integer rememberMeSeconds=3600;
	}

	/**
	 * 所有验证码的配置属性
	 */
	@Data
	@EqualsAndHashCode(callSuper = false)
	public static class CaptchaProperties{
		private ImageCaptchaProperties image=new ImageCaptchaProperties();
		private SmsCaptchaProperties sms=new SmsCaptchaProperties();
		/**
		 * 图形验证码配置属性
		 */
		@Data
		@EqualsAndHashCode(callSuper = false)
		public static class ImageCaptchaProperties extends SmsCaptchaProperties{
			private Integer width=67;
			private Integer height=23;

			/**
			 * 属性不能被覆盖或重写，无论this.*还是super.*访问的都是同一个属性，如果子类中有
			 * 和父类同名的属性时候，this.*和super.*才会有区别，下面的处理和同名属性相似
			 */
			public ImageCaptchaProperties(){
				setLength(4);
			}
		}

		/**
		 * 短信验证码配置属性
		 */
		@Data
		public static class SmsCaptchaProperties{
		//	验证码长度
			protected Integer length=4;
		//	过期时间
			protected Integer expireSecond=60;
		//	需要手机验证的url
			protected String url="";
		}
	}
	/**
	 * social相关配置
	 */
	@Data
	public static class SocialProperties{
	//	social通用的处理url,默认的social框架默认的相同，都是/auth,配置在此处，可以自行修改
		private String filterProcessesUrl="/auth";
		/**
		 * qq相关配置
		 */
		private QQProperties qq=new QQProperties();
		/**
		 * 微信相关配置
		 */
		private WeiXinProperties weixin=new WeiXinProperties();
		/**
		 * qq的一些配置属性
		 */
		@Data
		@EqualsAndHashCode(callSuper = false)
		public static class QQProperties{
			//application id
			private String appId;
			//application secret
			private String appSecret;
			//服务商标识
			private String providerId="qq";
		}
		/**
		 * 微信相关配置类
		 */
		@Data
		@EqualsAndHashCode(callSuper = false)
		public static class WeiXinProperties{
			//application id
			private String appId;
			//application secret
			private String appSecret;
			//服务商标识
			private String providerId="weixin";
		}
	}
	/**
	 * Oauth2协议相关配置
	 */
	@Data
	public static class Oauth2Properties{
		/**
		 * 配置第三方应用集合
		 */
		private List<OAuth2ClientProperties> clients=new ArrayList<>();
		/**
		 * jwt令牌签名密钥
		 */
		private String jwtSigningKey="zx";
		/**
		 * 使用的token类型 redis/jwt
		 */
		private String storeType="jwt";

		/**
		 * OAuth2协议 client端 相关配置
		 *
		 * 以下的list默认值之所以使用外层ArrayList再次包装,是因为
		 * Arrays.asList等方法返回的list只是其内部类中的ArrayList类.是一个视图List.
		 * 为防止可能发生的错误.
		 */
		@Data
		@EqualsAndHashCode(callSuper = false)
		public static class OAuth2ClientProperties {
			/**
			 * 第三方应用id
			 */
			private String clientId;
			/**
			 * 第三方应用密钥
			 */
			private String clientSecret;
			/**
			 *  令牌有效时间
			 */
			private Integer accessTokenValiditySeconds = 0;

			/**
			 *  允许访问的OAuth2协议模式集合
			 */
			private List<String> authorizedGrantTypes = new ArrayList<>(Arrays.asList("refresh_token","password"));
			/**
			 *  允许使用的权限范围集合
			 */
			private List<String> scopes = new ArrayList<>(Collections.singletonList("all"));
		}
	}
}
