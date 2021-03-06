package com.zheng.cpw.shiro;

import com.zheng.common.util.MD5Util;
import com.zheng.common.util.PropertiesFileUtil;
import com.zheng.cpw.dao.model.CpwUser;
import com.zheng.cpw.rpc.api.CpwUserService;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户认证和授权
 * Created by shuzheng on 2017/1/20.
 */
public class UcenterRealm extends AuthorizingRealm {

    private static Logger _log = LoggerFactory.getLogger(UcenterRealm.class);

   // private UpmsApiService upmsApiService;

    private CpwUserService ucenterUserService;


    public CpwUserService getUcenterUserService() {
        return ucenterUserService;
    }

    public void setUcenterUserService(CpwUserService ucenterUserService) {
        this.ucenterUserService = ucenterUserService;
    }

    /**
     * 授权：验证权限时调用
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Set<String> permissions = new HashSet<>();
        Set<String> roles = new HashSet<>();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证：登录时调用
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        // client无密认证
        String upmsType = PropertiesFileUtil.getInstance("zheng-upms-client").get("zheng.upms.type");

        if ("client".equals(upmsType)) {
            return new SimpleAuthenticationInfo(username, password, getName());
        }
        // 查询用户信息
        CpwUser ucenterUser = ucenterUserService.selectByPrimaryKey(1);

        if (null == ucenterUser) {
            throw new UnknownAccountException();
        }
        if (!ucenterUser.getPassword().equals(MD5Util.MD5(  ucenterUser.getSalt()+password))) {
            throw new IncorrectCredentialsException();
        }
//        if (ucenterUser.getLocked() == 1) {
//            throw new LockedAccountException();
//        }

        return new SimpleAuthenticationInfo(username, password, getName());
    }

}
