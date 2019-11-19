package com.liu.config;

import com.liu.Repository.UserRepository;
import com.liu.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserRepository userRepository;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 用户认证
     *
     * @param
     * @return
     * @throws
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken user = (UsernamePasswordToken) token;//获取用户名
        User user1 = userRepository.findUserByUsernameAndPassword(user.getUsername(), String.copyValueOf(user.getPassword()));

        if (user1 == null) {
            throw new UnknownAccountException("账户不存在!!!");
        }

        return new SimpleAuthenticationInfo(user1.getUsername(), user1.getPassword(), getName());
        /*
        getName()是获取当前realm的名称。
         */
    }
}
