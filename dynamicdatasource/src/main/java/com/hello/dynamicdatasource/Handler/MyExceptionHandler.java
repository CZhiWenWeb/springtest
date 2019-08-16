package com.hello.dynamicdatasource.Handler;

import com.hello.dynamicdatasource.common.CommonResponse;
import com.hello.dynamicdatasource.common.ResponseCode;
import com.hello.dynamicdatasource.execption.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: czw
 * @CreateTime: 2019-08-06 11:48
 * @UpdeteTime: 2019-08-06 11:48
 * @Description:
 */
@RestControllerAdvice
public class MyExceptionHandler {
	private static final Logger LOGGER= LoggerFactory.getLogger(MyExceptionHandler.class);

	/**
	 * 处理所有不可知的异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	CommonResponse handleException(Exception e){
		LOGGER.error(e.getMessage(),e);

		CommonResponse response=new CommonResponse();
		response.setCode(ResponseCode.INTERNAL_SERVER_ERROR);
		response.setMessage("操作失败");
		System.out.println(response);
		return response;
	}

	/**
	 * 处理业务异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BusinessException.class)
	CommonResponse handleBusinessException(BusinessException e){
		LOGGER.error(e.getMessage(),e);

		CommonResponse response=new CommonResponse();
		response.setCode(ResponseCode.INTERNAL_SERVER_ERROR);
		response.setMessage(e.getMessage());
		System.out.println(response);
		return response;
	}

	/**
	 * 处理数据校验异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BindException.class)
	CommonResponse handleMethodArgumentNotValidException(BindException e){
		LOGGER.error(e.getMessage(),e);
		CommonResponse response=new CommonResponse();
		response.setCode(ResponseCode.DATA_ERROR);
		response.setMessage(e.getMessage());
		System.out.println(response);
		return response;
	}
}
