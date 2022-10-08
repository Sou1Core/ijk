package com.gxa.service.impl;

import com.gxa.entity.User;
import com.gxa.mapper.UserMapper;
import com.gxa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String userName, String pwd) {
        User user = this.userMapper.queryByUserNameAndPwd(userName,pwd);
        return user ;
    }
}
