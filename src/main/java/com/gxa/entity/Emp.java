package com.gxa.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Emp {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private double sal;
    private double comm;
    private Dept dept;


}
