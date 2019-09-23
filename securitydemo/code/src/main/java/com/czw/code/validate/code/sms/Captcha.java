package com.czw.code.validate.code.sms;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: czw
 * @CreateTime: 2019-09-23 10:29
 * @UpdeteTime: 2019-09-23 10:29
 * @Description:
 */
@Data
//全参数构造函数
@AllArgsConstructor
public class Captcha implements Serializable {
	//随机数
	protected String code;
	//过期时间
	protected LocalDateTime expireTime;

	public Captcha(String code,int expireSecond){
		this.code=code;
		this.expireTime=LocalDateTime.now().plusSeconds(expireSecond);
	}

	public boolean isExpired() {
		return LocalDateTime.now().isAfter(expireTime);
	}
}
