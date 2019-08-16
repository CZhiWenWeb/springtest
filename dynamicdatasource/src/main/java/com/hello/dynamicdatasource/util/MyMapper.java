package com.hello.dynamicdatasource.util;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: czw
 * @CreateTime: 2019-08-02 17:06
 * @UpdeteTime: 2019-08-02 17:06
 * @Description:
 */
public interface MyMapper<T> extends Mapper<T>,
		MySqlMapper<T> ,
		IdsMapper<T> ,
		ConditionMapper<T> {
}
