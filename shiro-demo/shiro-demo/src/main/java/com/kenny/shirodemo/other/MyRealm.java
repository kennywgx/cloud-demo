package com.kenny.shirodemo.other;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.kenny.shirodemo.entity.Permission;
import com.kenny.shirodemo.entity.Role;
import com.kenny.shirodemo.entity.UserInfo;
import com.kenny.shirodemo.service.UserInfoServiceImpl;

public class MyRealm extends AuthorizingRealm {

	@Autowired
	private UserInfoServiceImpl userInfoService;
	
	private final static String saltForEncrypt = "qazxswedcvfr";
	
	/**
	 * 授权, 获取数据库的权限放到authorization里
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("权限配置 -->MyShiroRealm.doGetAuthorizationInfo()");
	    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
	    UserInfo userInfo  = (UserInfo)principals.getPrimaryPrincipal();
	    for(Role role : userInfo.getRoles()){
	        authorizationInfo.addRole(role.getName());
	        for(Permission p : role.getPermissions()){
	            authorizationInfo.addStringPermission(p.getCode());
	        }
	    }
	    return authorizationInfo;
	}

	/**
	 * 认证
	 */
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		 System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
	    //获取用户的输入的账号.
	    String username = (String)token.getPrincipal();
	    System.out.println(token.getCredentials());
	    //通过username从数据库中查找 User对象，如果找到，没找到.
	    //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
	    UserInfo userInfo = userInfoService.getByUsername(username);
	    System.out.println(userInfo);
	    if(userInfo == null){
	        return null;
	    }
	    return new SimpleAuthenticationInfo(
	            userInfo, //用户名
	            userInfo.getPassword(), //密码
	            ByteSource.Util.bytes(saltForEncrypt),
	            getName()  //realm name
	    );
	}

}
