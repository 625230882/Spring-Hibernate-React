package com.antra.assignment1.service;

import com.antra.assignment1.dao.EmployeeDao;
import com.antra.assignment1.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDao dao;

    @Override
    @Transactional
    public void addEmployee(Employee e) {
        dao.addEmployee(e);
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        List<Employee> dList = dao.findAllEmployees();
        return dList;
    }
}
