package com.dynamic.dynamic.druid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-07-30 17:28
 * @UpdeteTime: 2019-07-30 17:28
 * @Description:
 */
public class DynamicDataSourceContextHolder {
	private static final ThreadLocal<String> contextHolder=new ThreadLocal<>();
	public static List<String> dataSourceIds=new ArrayList<>();

	public static void setDataSourceType(String dataSourceType){
		contextHolder.set(dataSourceType);
	}
	public static String getDataSourceType(){
		return contextHolder.get();
	}
	public static void clearDataSourceType(){
		contextHolder.remove();
	}

	public static boolean containDataSource(String dataSourceId){
		return dataSourceIds.contains(dataSourceId);
	}
}
