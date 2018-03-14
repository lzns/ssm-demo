package com.dzf.shiro;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dzf.entity.Role;
import com.dzf.entity.User;
import com.dzf.service.IRoleService;
import com.dzf.service.IUserService;
import org.apache.shiro.authc.*;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * shiro的核心
 * @author dingzf
 * @date 2018年2月3日
 * @time 20:27:41
 */
public class MyRealm extends AuthorizingRealm{
	
	private static final Logger log = LoggerFactory.getLogger(MyRealm.class);
	
	@Autowired
	private IUserService iUserService;

	@Autowired
	private IRoleService iRoleService;

	private CacheManager cacheManager;
	private CredentialsMatcher credentialsMatcher;

	@Override
	public CacheManager getCacheManager() {
		return cacheManager;
	}
	@Override
	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
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
		List<Role> roleList = user.getRoleList();
		Set<String> roles = new HashSet<>();
		for (Role role : roleList) {
			roles.add(role.getRoleName());
		}
		info.setRoles(roles);
		return info;
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		log.info("++++++++++++登录认证开始++++++++++");
		UsernamePasswordToken upt = (UsernamePasswordToken) token;
		String username = upt.getUsername();
		//System.out.println(token.getCredentials());
		List<User> list = iUserService.selectList(new EntityWrapper<User>().eq("login_name", username));
		User user = null;
		if(list != null && list.size()>0){
			user = list.get(0);
		}
		if(user == null){
			return null;
		}
		//TODO 关于用户所具有的的权限封装进用户的信息里
        //Role role = iRoleService.queryRoleByUserId( user.getId());
		user = iUserService.selectRoleByUserId(user.getId());
        //log.info("传入SimpleAuthenticationInfo里面的参数值：{}，{}，{}，{}",user,user.getPassword(),new SimpleByteSource(user.getSalt()),getName());
		//SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), new SimpleByteSource(user.getSalt()), getName());
		log.info("通过Id查询的user为:{}",user);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), new ShiroByteSource(user.getSalt()), getName());
		//User primaryPrincipal = (User) info.getPrincipals().getPrimaryPrincipal();
		//System.out.println("尝试获取SimpleAuthenticationInfo中的信息："+primaryPrincipal);
		return info;
	}
	
	/**
	 * 在用户退出的时候清除掉缓存
	 */
	@Override
	public void onLogout(PrincipalCollection principals) {
		log.info("退出系统，清楚掉缓存的用户信息：{}",principals);
        super.clearCachedAuthenticationInfo(principals);
        super.clearCachedAuthorizationInfo(principals);
        User user=  (User) principals.getPrimaryPrincipal();
        SimplePrincipalCollection principals2 = new SimplePrincipalCollection();
        principals2.add(user.getLogin_name(), super.getName());
        super.clearCachedAuthenticationInfo(principals2);
	}
}
