package com.czw.browser.data.service.impl;

import com.czw.browser.data.service.BaseService;
import com.czw.browser.data.util.MyMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-08-23 14:14
 * @UpdeteTime: 2019-08-23 14:14
 * @Description:
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	@Autowired
	protected MyMapper<T> mapper;
	private Class<T> clazz;

	public BaseServiceImpl() {
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

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
	public List<T> selectByExample(String field, Object example) {
		Example example1 = new Example(clazz);
		Example.Criteria criteria = example1.createCriteria();
		criteria.andEqualTo(field, example);
		return mapper.selectByExample(example1);
	}

	@Override
	public int selectCountByExample(Object example) {

		return mapper.selectCountByExample(example);
	}

	@Override
	public int updateByExample(T record, Object example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int deleteByExample(Object example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
		return mapper.selectByExampleAndRowBounds(example, rowBounds);
	}

	@Override
	public int batchDelete(List<String> list, String property, Class<T> clazz) {
		Example example = new Example(clazz);
		example.createCriteria().andIn(property, list);
		return this.mapper.deleteByExample(example);
	}
}
