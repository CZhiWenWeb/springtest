package com.xyx.shiro.util;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: czw
 * @CreateTime: 2019-08-23 13:34
 * @UpdeteTime: 2019-08-23 13:34
 * @Description:
 */
public interface MyMapper<T> extends Mapper<T>,
		MySqlMapper<T>,
		IdsMapper<T>,
		ConditionMapper<T> {
}
