package com.dzf.shiro;

import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;

import java.util.Collection;
import java.util.Set;

/**
 * <p> 自定义缓存 将数据存入到redis中 </p>
 * @author dingzf
 * @date 2018年2月1日
 * @time 22:32:11
 * @param <K>
 * @param <V>
 */
@SuppressWarnings("unchecked")
public class ShiroSpringCache<K,V> implements org.apache.shiro.cache.Cache<K, V>{
	private static final Logger log = LoggerFactory.getLogger(ShiroSpringCache.class);
	private CacheManager cacheManager;
	private Cache cache;
//	private RedisCache cache2;
	public ShiroSpringCache(String name, CacheManager cacheManager) {
		if(name==null || cacheManager==null){
			throw new IllegalArgumentException("cacheManager or CacheName cannot be null.");
		}
		this.cacheManager = cacheManager;
		//这里首先是从父类中获取这个cache,如果没有会先创建一个redisCache,初始化这个redisCache的时候
		//会设置它的过期时间如果没有配置过这个缓存的，那么默认的缓存时间是为0的，如果配置了，就会重新创建一个
		//如果从缓存中取到就可以拿得到，这个redisCache实现了spring中的cache
		this.cache= cacheManager.getCache(name);
	}
	@Override
	public V get(K key) throws CacheException {
		log.info("从缓存中获取key为{}的缓存信息",key);
		if(key == null){
			return null;
		}
		ValueWrapper valueWrapper = cache.get(key);
		if(valueWrapper==null){
//			throw new RuntimeException("缓存的值是空的！！！");
			return null;
		}
		return (V) valueWrapper.get();
	}

	@Override
	public V put(K key, V value) throws CacheException {
		log.info("创建新的缓存，信息为：{}={}",key,value);
		cache.put(key, value);
		return get(key);
	}

	@Override
	public V remove(K key) throws CacheException {
		log.info("干掉key为{}的缓存",key);
		V v = get(key);
		cache.evict(key);//干掉这个名字为key的缓存
		return v;
	}

	@Override
	public void clear() throws CacheException {
		log.info("清空所有的缓存");
		cache.clear();
	}

	@Override
	public int size() {
		return cacheManager.getCacheNames().size();
	}

	/**
	 * 获取缓存中所的key值
	 */
	@Override
	public Set<K> keys() {
		return (Set<K>) cacheManager.getCacheNames();
	}

	/**
	 * 获取缓存中所有的values值
	 */
	@Override
	public Collection<V> values() {
		return (Collection<V>) cache.get(cacheManager.getCacheNames()).get();
	}

	@Override
	public String toString() {
		return "ShiroSpringCache [cache=" + cache + "]";
	}
}
