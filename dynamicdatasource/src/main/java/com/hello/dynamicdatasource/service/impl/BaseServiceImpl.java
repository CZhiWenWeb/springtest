package com.hello.dynamicdatasource.service.impl;

import com.github.pagehelper.PageHelper;
import com.hello.dynamicdatasource.service.BaseService;
import com.hello.dynamicdatasource.util.MyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-08-05 09:05
 * @UpdeteTime: 2019-08-05 09:05
 * @Description:
 */

/**
 * 基于通用mapper的mybatis来实现基础业务
 * @param <T>
 */
@Component
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	@Autowired
	protected MyMapper<T> mapper;
	//分页参数
	@Value("${my.pageHelp.page}")
	private int page;
	@Value("${my.pageHelp.rows}")
	private int rows;
	//获取当前泛型真实类型的Class
	private Class<T> modelClass;

	public BaseServiceImpl(){
		ParameterizedType pt= (ParameterizedType) this.getClass().getGenericSuperclass();
		this.modelClass= (Class<T>) pt.getActualTypeArguments()[0];
	}

	protected static Logger logger=LoggerFactory.getLogger(BaseServiceImpl.class);

	@Override
	public Integer save(T bean) {
		return mapper.insertSelective(bean);
	}

	@Override
	public Integer save(List<T> beans) {
		return mapper.insertList(beans);
	}

	@Override
	public Integer deleteById(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer deleteByIds(String ids) {
		return mapper.deleteByIds(ids);
	}

	@Override
	public Integer update(T model) {
		return mapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public T findById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}
	//异常处理未完成
	@Override
	public T findBy(String property, Object value) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
		T bean=modelClass.newInstance();
		Field field=modelClass.getDeclaredField(property);
		//设置不受检查，可以改变bean属性，通过获取getDeclaredConstructor()方法获取私有方法
		//后，设置如下属性可以多次调用单例构造器。。
		field.setAccessible(true);
		//bean实例的field字段的值设置为value
		field.set(bean,value);
		return mapper.selectOne(bean);
	}

	@Override
	public List<T> findByIds(String ids) {
		return mapper.selectByIds(ids);
	}

	@Override
	public List<T> findByCondition(Condition condition) {
		return mapper.selectByCondition(condition);
	}

	@Override
	public List<T> findAll() {
		PageHelper.startPage(page,rows);
		return mapper.selectAll();
	}
}
