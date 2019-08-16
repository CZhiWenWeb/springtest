package com.hello.dynamicdatasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author: czw
 * @CreateTime: 2019-08-13 14:08
 * @UpdeteTime: 2019-08-13 14:08
 * @Description:
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() {
		return DynamicDataSourceContextHolder.getDataSourceKey();
	}
}
