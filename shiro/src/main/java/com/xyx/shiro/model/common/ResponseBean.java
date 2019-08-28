package com.xyx.shiro.model.common;

/**
 * @Author: czw
 * @CreateTime: 2019-08-26 15:14
 * @UpdeteTime: 2019-08-26 15:14
 * @Description:
 */
public class ResponseBean {
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

	public ResponseBean(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
