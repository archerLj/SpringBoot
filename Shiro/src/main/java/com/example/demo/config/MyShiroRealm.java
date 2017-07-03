package com.example.demo.config;

import com.example.demo.entity.SysPermission;
import com.example.demo.entity.SysRole;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * Created by archerlj on 2017/6/30.
 */


public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserInfoService userInfoService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("开始身份验证");
        String username = (String) token.getPrincipal();
        UserInfo userInfo = userInfoService.findByUsername(username);

        if (userInfo == null) {
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()), //salt=username+salt
                getName() //realm name
        );

        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("开始权限配置");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();

        for (SysRole role: userInfo.getRoleList()) {
            authorizationInfo.addRole(role.getRole());
            for (SysPermission p: role.getPermissions()) {
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }

        return authorizationInfo;
    }
}
