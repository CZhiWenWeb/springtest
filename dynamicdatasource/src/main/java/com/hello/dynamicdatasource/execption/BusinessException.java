package com.hello.dynamicdatasource.execption;

/**
 * @Author: czw
 * @CreateTime: 2019-08-06 11:46
 * @UpdeteTime: 2019-08-06 11:46
 * @Description:
 */
public class BusinessException extends RuntimeException{
	public BusinessException(){
		super();
	}
	public BusinessException(String message){
		super(message);
	}
}
