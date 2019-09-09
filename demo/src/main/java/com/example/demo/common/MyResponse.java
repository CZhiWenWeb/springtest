package com.example.demo.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: czw
 * @CreateTime: 2019-09-04 14:43
 * @UpdeteTime: 2019-09-04 14:43
 * @Description:
 */
@Getter
@Setter
public class MyResponse {
	/**
	 * HTTP状态码
	 */
	private Integer code;

	/**
	 * 返回信息
	 */
	private String msg;

	/**
	 * 返回的数据
	 */
	private Object data;

	public MyResponse(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
}
