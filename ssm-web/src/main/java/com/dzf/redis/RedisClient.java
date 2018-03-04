package com.dzf.redis;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

/**
 * <p>redis 客户端,使用jedis来操作redis
 * 使用redis的主从复制</p>
 * 
 * @author dingzf
 * @date 2017年11月30日
 * @time 21:23:56
 */

//@Component
public class RedisClient {

	@Autowired
	private Jedis masterJedis;
	
	@Autowired
	private Jedis slaveJedis;
	
	public void setKey(String name,String value){
		masterJedis.set(name, value);
	}
	public String getKey(String name){
		return slaveJedis.get(name);
	}
	/**
	 * 设置过期时间，可以用来将短信验证码存在这里
	 * @param name
	 * @param expire
	 */
	public Long setKeyExpired(String name,int expire){
		return masterJedis.expire(name, expire);
	}
	/**
	 * 操作list
	 */
	public Long setKeys(String key,String ... value){
		return masterJedis.lpush(key, value);
	}
	
	public List<String> getKeys(String key){
		return slaveJedis.lrange(key, 0, -1);//表示获取所有的值
	}
	
	/**
	 * 操作hash
	 */
	public String setHash(String key,Map<String,String> map){
		return masterJedis.hmset(key, map);
	}
	public List<String> getHash(String key,String ...fields){
		return slaveJedis.hmget(key, fields);
	}
	
}
