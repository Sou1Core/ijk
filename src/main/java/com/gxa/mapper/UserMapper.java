package com.gxa.mapper;

import com.gxa.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface UserMapper {
    User queryByUserNameAndPwd(@Param("userName") String userName, @Param("pwd") String pwd);
    User queryByUserName(String userName);
    Set<String> queryPermsByUserName(String userName);
}
