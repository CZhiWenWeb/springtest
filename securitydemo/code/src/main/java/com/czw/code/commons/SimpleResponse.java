package com.czw.code.commons;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;

/**
 * @Author: czw
 * @CreateTime: 2019-09-23 10:05
 * @UpdeteTime: 2019-09-23 10:05
 * @Description:
 */
@Data
public class SimpleResponse<T> {
	//操作返回数据
	private T data;
	//操作结果
	private HttpStatus result;
	//曹祖返回错误信息
	private Map<String, Object> errorMsg;
}
