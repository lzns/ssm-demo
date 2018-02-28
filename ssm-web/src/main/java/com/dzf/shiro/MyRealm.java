package com.dzf.shiro;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dzf.entity.User;
import com.dzf.service.IUserService;

/**
 * shiro的核心
 * @author dingzf
 * @date 2018年2月3日
 * @time 20:27:41
 */
public class MyRealm extends AuthorizingRealm{
	
	private static final Logger log = LoggerFactory.getLogger(MyRealm.class);
	
	@Resource
	private IUserService iUserService;
	
	private CacheManager chacheManager;
	private CredentialsMatcher credentialsMatcher;
	public CacheManager getChacheManager() {
		return chacheManager;
	}
	public void setChacheManager(CacheManager chacheManager) {
		this.chacheManager = chacheManager;
	}

	public CredentialsMatcher getCredentialsMatcher() {
		return credentialsMatcher;
	}
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		this.credentialsMatcher = credentialsMatcher;
	}
	/**
	 * 权限认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		log.info("++++++++++shiro 权限认证开始 ++++++++++++++++");
		User user = (User) principals.getPrimaryPrincipal();
		log.info("principals中放入的信息为：{}",user);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// TODO将用户具有的角色和权限写进info里面
		return info;
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		log.info("++++++++++++登录认证开始++++++++++");
		UsernamePasswordToken upt = (UsernamePasswordToken) token;
		String userame = upt.getUsername();
		System.out.println(token.getCredentials());
		List<User> list = iUserService.selectList(new EntityWrapper<User>().eq("login_name", userame));
		User user = null;
		if(list != null && list.size()>0){
			user = list.get(0);
		}
		if(user == null){
			return null;
		}
		//TODO 关于用户所具有的的权限封装进用户的信息里
		log.info("传入SimpleAuthenticationInfo里面的参数值：{}，{}，{}，{}",user,user.getPassword(),new SimpleByteSource(user.getSalt()),getName());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), new SimpleByteSource(user.getSalt()), getName());
		User primaryPrincipal = (User) info.getPrincipals().getPrimaryPrincipal();
		System.out.println("尝试获取SimpleAuthenticationInfo中的信息："+primaryPrincipal);
		return info;
	}
	
	/**
	 * 在用户退出的时候清除掉缓存
	 */
	@Override
	public void onLogout(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
		User user=  (User) principals.getPrimaryPrincipal();
		SimplePrincipalCollection principals2 = new SimplePrincipalCollection();
        principals2.add(user.getLogin_name(), super.getName());
        super.clearCachedAuthenticationInfo(principals2);
	}
	

}
