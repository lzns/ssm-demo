package com.dzf.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * reids配置类
 * 
 * @author dingzf
 * @date 2017年11月30日
 * @time 20:59:47
 */
//@Configuration
public class RedisConfig {
	@Value("${redis.maxIdle}")
	private Integer maxIdle;
	@Value("${redis.maxTotal}")
	private Integer maxTotal;
	@Value("${redis.maxWaitMills}")
	private Integer maxWaitMills;
	@Value("${redis.timeout}")
	private Integer timeout;

	//master
	@Value("${redis.masterHost}")
	private String masterHost;
	@Value("${redis.masterPort}")
	private Integer masterPort;
	@Value("${redis.masterPassword}")
	private String masterPassword;
	//slave
	@Value("${redis.slaveHost}")
	private String slaveHost;
	@Value("${redis.slavePort}")
	private Integer slavePort;
	@Value("${redis.slavePassword}")
	private String slavePassword;
	
	@Bean(name="masterJedis")
	private Jedis getMasterRedis(){
		return intiJedis(masterHost,masterPassword,masterPort,timeout);
	}
	@Bean(name="slaveJedis")
	private Jedis getSlaveRedis(){
		return intiJedis(slaveHost,slavePassword,slavePort,timeout);
	}
	private Jedis intiJedis(String host, String password, Integer port,Integer timeout) {
		JedisPoolConfig pool = new JedisPoolConfig();
		pool.setMaxIdle(maxIdle);
		pool.setMaxTotal(maxTotal);
		pool.setMaxWaitMillis(maxWaitMills);
		JedisPool jedis = new JedisPool(pool, host, port, timeout, password);
		return jedis.getResource();
	}
	public static void closeJedis(Jedis jedis){
		if(jedis!=null){
			jedis.close();
		}
	}
	
}
