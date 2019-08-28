package com.xyx.shiro.service.impl;

import com.xyx.shiro.service.BaseService;
import com.xyx.shiro.util.MyMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-08-23 14:14
 * @UpdeteTime: 2019-08-23 14:14
 * @Description:
 */
public class BaseServiceImpl<T> implements BaseService<T> {
	@Autowired
	protected MyMapper<T> mapper;
	@Override
	public List<T> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public T selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public T selectOne(T record) {
		return mapper.selectOne(record);
	}

	@Override
	public int insertSelective(T record) {
		return mapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKey(T record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int delete(T record) {
		return mapper.delete(record);
	}

	@Override
	public int deleteByPrimaryKey(Object key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public List<T> selectByExample(Object example) {
		return mapper.selectByExample(example);
	}

	@Override
	public int selectCountByExample(Object example) {
		return mapper.selectCountByExample(example);
	}

	@Override
	public int updateByExample(T record, Object example) {
		return mapper.updateByExample(record,example);
	}

	@Override
	public int deleteByExample(Object example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
		return mapper.selectByExampleAndRowBounds(example,rowBounds);
	}
}
