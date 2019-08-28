package com.xyx.shiro.exception;

/**
 * @Author: czw
 * @CreateTime: 2019-08-24 09:48
 * @UpdeteTime: 2019-08-24 09:48
 * @Description:
 */
public class CustomException extends RuntimeException {
	public CustomException() {
		super();
	}

	public CustomException(String msg) {
		super(msg);
	}
}
