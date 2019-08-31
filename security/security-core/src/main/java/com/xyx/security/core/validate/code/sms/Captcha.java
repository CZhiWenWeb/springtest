package com.xyx.security.core.validate.code.sms;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: czw
 * @CreateTime: 2019-08-31 11:48
 * @UpdeteTime: 2019-08-31 11:48
 * @Description:
 */
@Data
//使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@AllArgsConstructor
public class Captcha implements Serializable {
//	随机数
	protected String code;
//	过期时间
	protected LocalDateTime expireTime;
	//提供一个String,int的构造函数
	public Captcha(String code,int expireSecond){
		this.code=code;
		this.expireTime=LocalDateTime.now().plusSeconds(expireSecond);
	}
	public boolean isExpired(){
		return LocalDateTime.now().isAfter(expireTime);
	}
}
