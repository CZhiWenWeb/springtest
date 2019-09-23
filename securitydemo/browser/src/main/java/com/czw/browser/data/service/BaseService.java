package com.czw.browser.data.service;

import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-08-23 14:13
 * @UpdeteTime: 2019-08-23 14:13
 * @Description:
 */
public interface BaseService<T> {
	/**
	 * 查询全部结果
	 *
	 * @return
	 */
	List<T> selectAll();

	/**
	 * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
	 *
	 * @param key
	 * @return T
	 */
	T selectByPrimaryKey(Object key);

	/**
	 * 根据实体中的属性(可以是某个属性)进行查询，只能有一个返回值，有多个结果抛出异常，查询条件使用等号
	 *
	 * @param record
	 * @return
	 */
	T selectOne(T record);

	/**
	 * 保存一个实体，null的属性不会保存，会使用数据库默认值
	 *
	 * @param record
	 * @return
	 */
	int insertSelective(T record);

	/**
	 * 根据主键更新实体全部字段，null会被更新
	 *
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(T record);

	/**
	 * 根据实体属性作为条件进行删除，查询条件使用等号
	 *
	 * @param record
	 * @return
	 */
	int delete(T record);

	/**
	 * 根据主键进行删除
	 *
	 * @param key
	 * @return
	 */
	int deleteByPrimaryKey(Object key);

	/**
	 * 根据Example条件进行查询，这个查询支持通过Example类指定查询列
	 * <p>
	 * 通过selectProperties方法指定查询列
	 *
	 * @param example
	 * @return
	 */
	List<T> selectByExample(String field, Object example);

	/**
	 * 根据Example条件进行查询总数
	 *
	 * @param example
	 * @return
	 */
	int selectCountByExample(Object example);

	/**
	 * 根据Example条件更新实体record包含的全部属性，null值（record中为null的属性）会被更新
	 *
	 * @param record
	 * @param example
	 * @return
	 */
	int updateByExample(T record, Object example);

	/**
	 * 根据Example条件输出数据
	 *
	 * @param example
	 * @return
	 */
	int deleteByExample(Object example);

	/**
	 * 根据example条件和RowBounds进行分页查询
	 *
	 * @param example
	 * @param rowBounds
	 * @return
	 */
	List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds);

	int batchDelete(List<String> list, String property, Class<T> tClass);
}
