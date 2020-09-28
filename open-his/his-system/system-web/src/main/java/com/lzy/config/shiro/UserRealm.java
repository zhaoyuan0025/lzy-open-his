package com.lzy.config.shiro;

import com.lzy.domain.User;
import com.lzy.service.UserService;
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

/**
 * @program: open-his
 * @description: 实现自定义的认证和授权
 * @author: lzy
 * @create: 2020-09-28 15:00
 **/
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 获取登录名
     * @return
     */
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     * 认证 登录
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //得到用户的登录名
        String phone = token.getPrincipal().toString();
        //根据电话去查询用户
        User user = userService.queryUserByPhone(phone);
        if(null != user){
            //说明用户存在，但是密码还是可能不正确的
            //匹配密码
            ActiverUser activerUser = new ActiverUser();
            activerUser.setUser(user);
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                    //user对象  密码  盐 realmname
                    activerUser,user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName()
            );
            return info;
        }else {
            //用户不存在
            return null;
        }
    }

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //身份得到的就是上一个方法的返回值的值 第一个参数activerUser
        ActiverUser activerUser = (ActiverUser) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }
}
