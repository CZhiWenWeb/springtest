package com.xyx.shiro.util;

import com.xyx.shiro.exception.CustomException;
import com.xyx.shiro.model.common.Constant;
import com.xyx.shiro.util.common.SerializableUtil;
import com.xyx.shiro.util.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * @Author: czw
 * @CreateTime: 2019-08-26 10:05
 * @UpdeteTime: 2019-08-26 10:05
 * @Description:推荐存Byte数组，存Json字符串效率更慢
 */
@Component
public class JedisUtil {

	private static JedisPool jedisPool;
	@Autowired
	public void setJedisPool(JedisPool jedisPool){
		this.jedisPool=jedisPool;
	}

	/**
	 *  获取Jeids实例
	 * @return
	 */
	public static synchronized Jedis getJedis(){
		try{
			if (jedisPool!=null){
				return jedisPool.getResource();
			}else {
				return null;
			}
		}catch (Exception e){
			throw new CustomException("获取Jedis异常："+e.getMessage());
		}
	}

	/**
	 * 释放Jedis资源
	 */
	public static void closePool(){
		try{
			jedisPool.close();
		}catch (Exception e){
			throw new CustomException("释放Jedis异常"+e.getMessage());
		}
	}

	/**
	 * 获取redis键值
	 * @param key
	 * @return
	 */
	public static Object getObject(String key){
		try{
			Jedis jedis=getJedis();
			byte[] bytes=jedis.get(key.getBytes());
			if (!StringUtil.isNull(bytes)){
				return SerializableUtil.unserializable(bytes);
			}else {
				return null;
			}
		}catch (Exception e){
			throw new CustomException("获取Redis键值getObject方法异常：key="+key+"cause="+e.getMessage());
		}
	}

	/**
	 * 设置redis键值object
	 * @param key
	 * @param value
	 * @return
	 */
	public static String setObject(String key,Object value){
		/**
		 * try(){
		 *
		 * }catch(){
		 *
		 * }自动资源管理，前提时可关闭的资源必须实现java.lang.AutoCloseable接口
		 */
		try(Jedis jedis=getJedis()){
			return jedis.set(key.getBytes(),SerializableUtil.serializable(value));
		}catch (Exception e){
			throw new CustomException("设置Redis键值setObject方法异常：key="+key+"value"+value+"cause"+e.getMessage());
		}
	}

	/**
	 * 设置redis键值-object-expiretime
	 * @param key
	 * @param value
	 * @param expiretime
	 * @return
	 */
	public static String setObject(String key,Object value,int expiretime){
		String result;
		try (Jedis jedis=getJedis()){
			result=jedis.set(key.getBytes(),SerializableUtil.serializable(value));
			if (Constant.OK.equals(result)){
				jedis.expire(key.getBytes(),expiretime);
			}
			return result;
		}catch (Exception e){
			throw new CustomException("设置Redis键值setObject方法异常:key=" + key + " value=" + value + " cause=" + e.getMessage());
		}
	}

	/**
	 * 删除key
	 * @param key
	 * @return
	 */
	public static Long delKey(String key){
		try(Jedis jedis=getJedis()){
			return jedis.del(key.getBytes());
		}catch (Exception e){
			throw new CustomException("删除Redis的键delKey方法异常:key=" + key + " cause=" + e.getMessage());
		}
	}

	/**
	 * key是否存在
	 * @param key
	 * @return
	 */
	public static  Boolean exists(String key){
		try(Jedis jedis=getJedis()){
			return jedis.exists(key.getBytes());
		}catch (Exception e){
			throw new CustomException("查询Redis的键是否存在exists方法异常:key=" + key + " cause=" + e.getMessage());
		}
	}

	/**
	 * 模糊查询获取key集合(keys的速度非常快，但在一个大的数据库中使用它仍然可能造成性能问题，生产不推荐使用)
	 * @param key
	 * @return
	 */
	public static Set<String> keysS(String key) {
		try (Jedis jedis = getJedis()) {
			return jedis.keys(key);
		} catch (Exception e) {
			throw new CustomException("模糊查询Redis的键集合keysS方法异常:key=" + key + " cause=" + e.getMessage());
		}
	}

	/**
	 *  模糊查询获取key集合(keys的速度非常快，但在一个大的数据库中使用它仍然可能造成性能问题，生产不推荐使用)
	 * @param key
	 * @return
	 */
	public static Set<byte[]> keysB(String key) {
		try (Jedis jedis = getJedis()) {
			return jedis.keys(key.getBytes());
		} catch (Exception e) {
			throw new CustomException("模糊查询Redis的键集合keysB方法异常:key=" + key + " cause=" + e.getMessage());
		}
	}

	/**
	 * 获取过期剩余时间
	 * @param key
	 * @return
	 */
	public static Long ttl(String key) {
		Long result = -2L;
		try (Jedis jedis = getJedis()) {
			result = jedis.ttl(key);
			return result;
		} catch (Exception e) {
			throw new CustomException("获取Redis键过期剩余时间ttl方法异常:key=" + key + " cause=" + e.getMessage());
		}
	}
}
