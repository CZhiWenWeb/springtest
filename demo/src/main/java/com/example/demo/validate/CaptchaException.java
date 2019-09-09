package com.example.demo.validate;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author: czw
 * @CreateTime: 2019-09-04 10:00
 * @UpdeteTime: 2019-09-04 10:00
 * @Description:
 */
public class CaptchaException extends AuthenticationException {
	public CaptchaException(String msg){
		super(msg);
	}
}
