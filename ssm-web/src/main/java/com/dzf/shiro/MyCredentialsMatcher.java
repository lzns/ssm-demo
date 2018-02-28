package com.dzf.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;
/**
 * 自定身份验证匹配器，如果输入超过5次，账户锁定30分钟
 * @author dingzf
 * @date 2018年2月3日
 * @time 16:00:06
 */
public class MyCredentialsMatcher extends HashedCredentialsMatcher implements InitializingBean {
	private static final Logger log = LoggerFactory.getLogger(MyCredentialsMatcher.class);
	
	private Cache<String, Integer> cache;
	private CacheManager cacheManager;
	private PasswordHash passwordHash;
	private String limitCacheName;
	
	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public PasswordHash getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(PasswordHash passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getLimitCacheName() {
		return limitCacheName;
	}

	public void setLimitCacheName(String limitCacheName) {
		this.limitCacheName = limitCacheName;
	}
	
	/**
	 * 进行身份匹配
	 * @param token
	 * @param info
	 * @return
	 */
	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
		String username = (String) authcToken.getPrincipal();
		log.info("获取authcToken的信息：{}",authcToken);
		log.info("身份密码验证器，传入的登录名是：",username);
		//retry count + 1
		Integer count = cache.get(username);
		if(count == null) {
			count = 0;
			cache.put(username, count);
		}
		if(count > 5) {
			log.warn("username: " + username + " tried to login more than 5 times in period");  
			throw new ExcessiveAttemptsException("用户名: " + username + " 密码连续输入错误超过5次，锁定半小时！"); 
		} else {
			cache.put(username, count);
		}
		log.info("密码连续输入错误的次数：{}",count);
		boolean match = super.doCredentialsMatch(authcToken, info);
		if(match){
			//删除 limitCache
			cache.remove(username);
		}
		return match;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("初始化密码比较器。。。。");
		Assert.notNull(passwordHash, "you must set passwordHash!");
		super.setHashAlgorithmName(passwordHash.getHashAlgorithm());
		super.setHashIterations(passwordHash.getHashIterations());
		this.cache = cacheManager.getCache(limitCacheName);
	}

}
