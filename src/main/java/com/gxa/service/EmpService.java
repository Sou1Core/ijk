package com.gxa.service;

import com.gxa.entity.Dept;
import com.gxa.entity.Emp;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmpService {
    List<Emp> queryAll();
    List<Dept> queryDepts();
    void add(Emp emp);
    Emp queryByEmpno(Integer empno);

    void update(Emp emp);

    void delete(Integer empno);
}
