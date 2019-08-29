package com.xyx.common.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: czw
 * @CreateTime: 2019-08-29 16:52
 * @UpdeteTime: 2019-08-29 16:52
 * @Description:
 */
public interface MyMapper<T> extends Mapper<T>,
		MySqlMapper<T> {
}
