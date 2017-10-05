package com.antra.assignment1.service;

import com.antra.assignment1.dao.DepartmentDao;
import com.antra.assignment1.data.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentDao dao;

    @Override
    @Transactional
    public void addDept(Department department) {
        dao.addDepartment(department);
    }

    @Override
    @Transactional
    public List<Department> loadDepartments() {
        return dao.findAllDepartments();
    }

}
