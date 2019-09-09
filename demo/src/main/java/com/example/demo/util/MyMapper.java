package com.example.demo.util;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: czw
 * @CreateTime: 2019-09-07 10:51
 * @UpdeteTime: 2019-09-07 10:51
 * @Description:
 */
public interface MyMapper<T> extends Mapper<T>,
		MySqlMapper<T>,
		IdsMapper<T>,
		ConditionMapper<T> {
}
