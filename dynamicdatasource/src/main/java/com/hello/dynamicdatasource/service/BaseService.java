package com.hello.dynamicdatasource.service;

import com.hello.dynamicdatasource.util.MyMapper;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-08-03 14:46
 * @UpdeteTime: 2019-08-03 14:46
 * @Description:
 */

/**
 * service的基础接口
 * @param <T>
 */
@Service
public interface BaseService<T>{
	/**
	 * @param bean
	 */
	Integer save(T bean);

	/**批量持久化
	 * @param beans
	 */
	Integer save(List<T> beans);

	/**
	 * 通过主键删除
	 * @param id
	 * @return
	 */
	Integer deleteById(Integer id);

	/**
	 * 批量删除 ids->"1,2,3"
	 * @param ids
	 * @return
	 */
	Integer deleteByIds(String ids);

	/**
	 * 更新
	 * @param model
	 * @return
	 */
	Integer update(T model);

	/**
	 * 通过ID查找
	 * @param id
	 * @return
	 */
	T findById(Integer id);

	/**
	 * 通过某个成员属性查找，value需符合unique约束
	 * @param property
	 * @param value
	 * @return
	 */
	T findBy(String property,Object value) throws IllegalAccessException, InstantiationException, NoSuchFieldException;

	/**
	 * 通过多个ID查找
	 * @param ids
	 * @return
	 */
	List<T> findByIds(String ids);

	/**
	 * 根据条件查找
	 * @param condition
	 * @return
	 */
	List<T> findByCondition(Condition condition);

	/**
	 * 查找所有
	 * @return
	 */
	List<T> findAll();
}
