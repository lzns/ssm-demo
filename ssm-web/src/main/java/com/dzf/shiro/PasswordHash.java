package com.dzf.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * 对密码加密配置
 * @author dingzf
 * @date 2018年2月3日
 * @time 16:10:33
 */
public class PasswordHash implements InitializingBean {
	private static final Logger log = LoggerFactory.getLogger(PasswordHash.class);
	//加密的名称 例如 MD5 base64 ...
	private String hashAlgorithm;
	//加密的次数
	private Integer hashIterations;

	public String getHashAlgorithm() {
		return hashAlgorithm;
	}
	public void setHashAlgorithm(String hashAlgorithm) {
		this.hashAlgorithm = hashAlgorithm;
	}
	public Integer getHashIterations() {
		return hashIterations;
	}
	public void setHashIterations(Integer hashIterations) {
		this.hashIterations = hashIterations;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		//检查指定的一个属性只能为指定的一些值
		Assert.hasLength(hashAlgorithm, "algorithmName mast be MD5、SHA-1、SHA-256、SHA-384、SHA-512");
	}
	/**
	 * 加密
	 * @param source 被加密的对象
	 * @param salt  加密盐
	 * @return
	 */
	public String toHex(Object source,Object salt){
		log.info("需要对{}进行加密,加密盐是{},加密算法是{},加密次数是{}",source,salt,hashAlgorithm,hashIterations);
		return new SimpleHash(hashAlgorithm, source, salt, hashIterations).toHex();
	}
	
}
