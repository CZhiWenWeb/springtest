package com.xyx.shiro.util.common;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @Author: czw
 * @CreateTime: 2019-08-24 09:16
 * @UpdeteTime: 2019-08-24 09:16
 * @Description:Base64工具
 */
public class Base64ConvertUtil
{
	/**
	 * 加密JDK1.8
	 * @param str
	 * @return
	 */
	public static String encode(String str) throws UnsupportedEncodingException {
		byte[] encodeBytes= Base64.getEncoder().encode(str.getBytes("utf-8"));
		return new String(encodeBytes);
	}

	/**
	 * 解密JDK1.8
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String decode(String str) throws UnsupportedEncodingException {
		byte[] decodeBytes = Base64.getDecoder().decode(str.getBytes("utf-8"));
		return new String(decodeBytes);
	}
}
