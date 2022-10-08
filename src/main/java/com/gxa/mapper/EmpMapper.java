package com.gxa.mapper;

import com.gxa.entity.Emp;

import java.util.List;

public interface EmpMapper {
    List<Emp> queryAll();
    void save(Emp emp);
    Emp queryByEmpno(Integer empno);

    void update(Emp emp);

    void deleteByEmpno(Integer empno);
}
