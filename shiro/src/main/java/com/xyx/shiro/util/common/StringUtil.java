package com.xyx.shiro.util.common;

/**
 * @Author: czw
 * @CreateTime: 2019-08-24 10:03
 * @UpdeteTime: 2019-08-24 10:03
 * @Description:
 */
public class StringUtil {
	/**
	 * 定义下划线
	 */
	private static final char UNDERLINE='_';

	/**
	 * String为空或”“判断（不允许空格）
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str){
		return str==null||"".equals(str.trim());
	}

	/**
	 * Byte数组为空判断
	 * @param bytes
	 * @return
	 */
	public static boolean isNull(byte[] bytes){
		return bytes==null||bytes.length==0;
	}

	/**
	 * 驼峰转下划线
	 * @param param
	 * @return
	 */
	public static String camelToUnderline(String param){
		if (!isBlank(param)){
			int len=param.length();
			StringBuffer sb=new StringBuffer(len);
			for (int i=0;i<len;i++){
				char c=param.charAt(i);
				if (Character.isUpperCase(c)){
					sb.append(UNDERLINE);
					sb.append(Character.toLowerCase(c));
				}else {
					sb.append(c);
				}
			}
			return sb.toString();
		}else {
			return "";
		}
	}

	/**
	 * 下划线转驼峰
	 * @param param
	 * @return
	 */
	public static String underlineToCamel(String param) {
		if (!isBlank(param)) {
			int len = param.length();
			StringBuilder sb = new StringBuilder(len);
			for (int i = 0; i < len; i++) {
				char c = param.charAt(i);
				if (c == 95) {
					++i;
					if (i < len) {
						sb.append(Character.toUpperCase(param.charAt(i)));
					}
				} else {
					sb.append(c);
				}
			}
			return sb.toString();
		} else {
			return "";
		}
	}

	/**
	 * 在字符串两边加上''
	 * @param param
	 * @return
	 */
	public static String addSingleQuotes(String param) {
		return "\'" + param + "\'";
	}
}
