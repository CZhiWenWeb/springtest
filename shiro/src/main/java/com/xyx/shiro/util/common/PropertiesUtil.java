package com.xyx.shiro.util.common;

import com.xyx.shiro.exception.CustomException;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @Author: czw
 * @CreateTime: 2019-08-24 09:41
 * @UpdeteTime: 2019-08-24 09:41
 * @Description:Properties工具
 */
@Slf4j
public class PropertiesUtil {
	/**
	 * PROP
	 */
	private static final Properties PROP=new Properties();

	/**
	 * 读取配置文件
	 * @param fileName
	 */
	public static void readProperties(String fileName){
		InputStream in=null;
		in=PropertiesUtil.class.getResourceAsStream("/"+fileName);
		BufferedReader bf=new BufferedReader(new InputStreamReader(in));
		try {
			PROP.load(bf);
		} catch (IOException e) {
			log.error("PropertiesUtil工具类读取配置文件出现IOException异常"+e.getMessage());
			throw new ClassCastException("PropertiesUtil工具类读取配置文件出现IOException异常:"+e.getMessage());
		}finally {
			if (in!=null){
				try {
					in.close();
				} catch (IOException e) {
					log.error("PropertiesUtil工具类读取配置文件出现IOException异常"+e.getMessage());
					throw new CustomException("PropertiesUtil工具类读取配置文件出现IOException异常"+e.getMessage());
				}
			}
		}
	}
	/**
	 * 根据key读取对应的value
	 * @param key
	 * @return java.lang.String
	 * @author dolyw.com
	 * @date 2018/8/31 17:29
	 */
	public static String getProperty(String key){
		return PROP.getProperty(key);
	}
}
