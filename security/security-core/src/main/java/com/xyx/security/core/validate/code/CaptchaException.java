package com.xyx.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author: czw
 * @CreateTime: 2019-08-31 14:48
 * @UpdeteTime: 2019-08-31 14:48
 * @Description:
 */
public class CaptchaException extends AuthenticationException {
	public CaptchaException(String msg) {
		super(msg);
	}
}
