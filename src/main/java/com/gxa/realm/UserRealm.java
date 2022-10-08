package com.gxa.realm;

import com.gxa.entity.User;
import com.gxa.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    @Autowired//自动装配
    private UserMapper userMapper;

    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("-----------------------认证方法-----------------------------");

        UsernamePasswordToken utoken = (UsernamePasswordToken) token;
        String username = utoken.getUsername();

        //根据用户名查询 用户对象 ，shiro会自动完成比对工作
        User user = this.userMapper.queryByUserName(username);//从数据库中查询的
        ByteSource salt = ByteSource.Util.bytes(user.getSalt());

        //三个参数： 第一个参数：当前登录这个用户   第二个参数：从数据库中查询的密码 第三个参数：realm名字
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPwd(),salt,this.getName());
        return authenticationInfo;
    }

    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("-----------------------授权方法-----------------------------");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

//        Set<String> perms = new HashSet<>();

        User user = (User) principalCollection.getPrimaryPrincipal();//获取当前登录的用户
        String username = user.getUserName();
//        if("admin".equals(username)) {
//            perms.add("emp:list");
//            perms.add("emp:add");
//            perms.add("emp:update");
//            perms.add("emp:delete");
//        }else if("zs".equals(username)) {
//            perms.add("emp:list");
//            perms.add("emp:add");
//            perms.add("emp:update");
//        }else if("ls".equals(username)) {
//            perms.add("emp:list");
//        }
        Set<String> perms = userMapper.queryPermsByUserName(username);

        authorizationInfo.addStringPermissions(perms);

        return authorizationInfo;
    }

    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        Object credentials = "ls";


//		Object result = new SimpleHash(hashAlgorithmName,credentials);
//		System.out.println(result);


//		Object result = new SimpleHash(hashAlgorithmName,credentials,null,1024);
//		System.out.println(result);

        Object salt = ByteSource.Util.bytes("789");;
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, 1024);
        System.out.println(result);
    }
}
