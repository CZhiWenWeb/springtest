package com.xyx.common.service.impl;

import com.xyx.common.service.IService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-08-29 17:01
 * @UpdeteTime: 2019-08-29 17:01
 * @Description:
 */
/**@Transactional注解中常用参数说明
 *readOnly=true 只读事务，一次执行多次查询统计信息，只读事务可以保证数据完整性
 * rollbackForClassName设置需要回滚的异常类名称数组
 * propagation 设置事务的传播行为，propagation=Propagation.SUPPORTS如果其他bean调用这个
 * 方法，在其他bean中声明事务就用事务，没有就不用
 * timeout 设置事务超时时间
 * isolation 设置数据库事务隔离级别，用于处理多事务并发情况，mysql默认可重复读，意思是：
 * 同一事务中多次读取数据时，能保证所读数据一样，后续读取不能读取到另一事务提交的更新数据
 * */
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public abstract class BaseService<T> implements IService<T> {
	@Override
	public List<T> selectAll() {
		return null;
	}

	@Override
	public T selectByKey(Object key) {
		return null;
	}

	@Override
	public int save(T entity) {
		return 0;
	}

	@Override
	public int delete(Object key) {
		return 0;
	}

	@Override
	public int batchDelete(List<String> list, String property, Class<T> clazz) {
		return 0;
	}

	@Override
	public int updateAll(T entity) {
		return 0;
	}

	@Override
	public int updateNotNull(T entity) {
		return 0;
	}

	@Override
	public List<T> selectByExample(Object example) {
		return null;
	}
}
