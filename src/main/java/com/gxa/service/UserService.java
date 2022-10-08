package com.gxa.service;

import com.gxa.entity.User;

public interface UserService {
    User login(String userName, String pwd);
}
