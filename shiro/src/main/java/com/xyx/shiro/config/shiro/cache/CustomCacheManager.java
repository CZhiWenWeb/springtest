package com.xyx.shiro.config.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * @Author: czw
 * @CreateTime: 2019-08-26 09:06
 * @UpdeteTime: 2019-08-26 09:06
 * @Description:重写shiro缓存管理器
 */
public class CustomCacheManager implements CacheManager {
	@Override
	public <K, V> Cache<K, V> getCache(String s) throws CacheException {
		return new CustomCache<K, V>();
	}
}
