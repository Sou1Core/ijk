package com.gxa.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String userName;
    private String pwd;
    private String salt;
}
