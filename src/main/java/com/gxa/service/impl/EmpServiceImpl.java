package com.gxa.service.impl;

import com.gxa.entity.Dept;
import com.gxa.entity.Emp;
import com.gxa.mapper.DeptMapper;
import com.gxa.mapper.EmpMapper;
import com.gxa.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Emp> queryAll() {
        List<Emp> emps = this.empMapper.queryAll();
        return emps;
    }

    @Override
    public List<Dept> queryDepts() {
        List<Dept> depts = this.deptMapper.queryAll();
        return depts;

    }

    @Override
    public void add(Emp emp) {
        this.empMapper.save(emp);
    }

    @Override
    public Emp queryByEmpno(Integer empno) {

        Emp emp = this.empMapper.queryByEmpno(empno);
        return emp;
    }

    @Override
    public void update(Emp emp) {
        this.empMapper.update(emp);
    }

    @Override
    public void delete(Integer empno) {
        this.empMapper.deleteByEmpno(empno);
    }
}
