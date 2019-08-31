package com.xyx.security.core.authentication.mobile;

import lombok.Setter;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author: czw
 * @CreateTime: 2019-08-31 10:18
 * @UpdeteTime: 2019-08-31 10:18
 * @Description:短息验证码身份验证提供者
 */
@Setter
public class SmsCaptchaAuthenticationProvider implements AuthenticationProvider {
	private UserDetailsService userDetailsService;

	/**
	 *身份验证逻辑
	 * @param authentication
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		//因为该提供者在supports()方法中只支持自定的手机号验证，所以此处强转
		SmsCaptchaAuthenticationToken authenticationToken= (SmsCaptchaAuthenticationToken) authentication;
		//取出手机号，从数据库中查询对应用户
		UserDetails user=userDetailsService.loadUserByUsername((String) authenticationToken.getPrincipal());
		if (user==null){
			throw new InternalAuthenticationServiceException("无法获取用户信息");
		}
		//读取到用户信息，重新构造authentication并返回1.用户信息2.用户权限（构造参数）
		SmsCaptchaAuthenticationToken result=new SmsCaptchaAuthenticationToken(user,user.getAuthorities());
		//将认证前SmsCaptchaAuthenticationToken的details字段信息放入认证后的result
		result.setDetails(authentication.getDetails());

		return result;
	}

	/**
	 * 如果过滤拦截下的，并获取到属性，创建了authenticationToken对象，符合该类要验证
	 * 的对象的条件，就返回true,表示支持验证该对象
	 *
	 * 此处判断是否时自己定义的那个token类的子类
	 * @param authentication
	 * @return
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		//验证是否未自己定义的类的父类或者本身
		return SmsCaptchaAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
