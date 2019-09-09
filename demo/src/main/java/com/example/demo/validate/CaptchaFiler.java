package com.example.demo.validate;

import com.example.demo.handler.CustomAuthenticationFailHandler;
import com.example.demo.properties.SecurityProperties;
import com.example.demo.validate.abstracts.CaptchaProcessor;
import com.example.demo.validate.image.Captcha;
import com.example.demo.validate.image.SessionCaptchaRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static com.example.demo.validate.abstracts.CaptchaProcessor.SESSION_CAPTCHA_PRE;

/**
 * @Author: czw
 * @CreateTime: 2019-09-04 09:51
 * @UpdeteTime: 2019-09-04 09:51
 * @Description:
 */
@Component
@Data
@Slf4j
public class CaptchaFiler extends OncePerRequestFilter implements InitializingBean {
	//失败处理器
	@Autowired
	private CustomAuthenticationFailHandler customAuthenticationFailHandler;
	//注入sessionCaptchaRepository，获取缓存的captcha
	@Autowired
	private SessionCaptchaRepository sessionCaptchaRepository;

	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

	private Set<String> urlSet = new HashSet<>();

	@Autowired
	private SecurityProperties securityProperties;

	//springSecurity中用来判断某个路径是否包含某个路径的工具类,例如/user/** 包含了/user/a
	private AntPathMatcher antPathMatcher = new AntPathMatcher();

	@Autowired
	private CaptchaRepository captchaRepository;
	//在初始化bean完成后,调用下面的方法
	@Override
	public void afterPropertiesSet() throws ServletException {
		super.afterPropertiesSet();//父类的实现不能删除
		//分割字符串过程中会按照每个分隔符进行分割，不忽略任何空白项；
		String[] urls = StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getCaptcha().getImage().getUrl(), ",");
		//将urls加入set
		CollectionUtils.addAll(urlSet,urls);

		//并且,一定加入登录请求，防止拦截进入登入页面的请求
		urlSet.add("/user/login");
	}
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		boolean flage = false;
		for (String s:urlSet
		     ) {
			if (antPathMatcher.match(s,request.getRequestURI())){
				flage=true;
				break;
			}
		}
		if (flage){
		try {
			validate(new ServletWebRequest(request));
		} catch (CaptchaException e) {
			customAuthenticationFailHandler.onAuthenticationFailure(request,response,e);
			return;
		}
		}
		//如果不是登录请求,直接调用后面的过滤器
		filterChain.doFilter(request,response);
	}

	//验证验证码是否正确
	private void validate(ServletWebRequest request) throws ServletRequestBindingException {

		//从session中获取正确的验证码
		Captcha captcha=sessionCaptchaRepository.get(request,SESSION_CAPTCHA_PRE);
//        Captcha captcha = (Captcha) sessionStrategy.getAttribute(request, CaptchaProcessor.SESSION_CAPTCHA_PRE + "image");
		//获取请求中的验证码
		String requestCaptcha = ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");

		//校验
		if(captcha == null)
			throw new CaptchaException("验证码不存在");
		if(StringUtils.isBlank(requestCaptcha))
			throw new CaptchaException("验证码不能为空");
		if(captcha.isExpired()){
//            sessionStrategy.removeAttribute(request, CaptchaProcessor.SESSION_CAPTCHA_PRE + "image");
			throw new CaptchaException("验证码已经过期");
		}
		if(!StringUtils.equalsIgnoreCase(captcha.getCode(),requestCaptcha)) {
			throw new CaptchaException("验证码不正确");
		}

		//执行到此处,表示验证通过
		sessionCaptchaRepository.remove(request,CaptchaProcessor.SESSION_CAPTCHA_PRE + "image");
	}
}
