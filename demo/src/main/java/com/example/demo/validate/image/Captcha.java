package com.example.demo.validate.image;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: czw
 * @CreateTime: 2019-09-04 09:05
 * @UpdeteTime: 2019-09-04 09:05
 * @Description:
 */
@Data
public class Captcha implements Serializable {
	//随机数
	protected String code;
	//过期时间
	protected LocalDateTime expireTime;
	public Captcha(String code,int expireTime){
		this.code=code;
		//当前时间加过期秒数
		this.expireTime=LocalDateTime.now().plusSeconds(expireTime);
	}
	public Captcha(String code,LocalDateTime expireTime){
		this.code=code;
		this.expireTime=expireTime;
	}
	public boolean isExpired(){
		return LocalDateTime.now().isAfter(expireTime);
	}
}
