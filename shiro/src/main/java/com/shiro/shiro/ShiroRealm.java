package com.shiro.shiro;

import com.shiro.bean.User;
import com.shiro.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;

    /**
     * 获取用户角色和权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    /**
     * 登录认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName= (String) token.getPrincipal();
        String password=new String((char[]) token.getCredentials());

        System.out.println("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");
        User user=userMapper.selectOneByExample(userName);

        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(user.getPassWord())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        if (user.getStaus().equals("0")) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }

        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user,password,getName());
        return info;
    }
}
