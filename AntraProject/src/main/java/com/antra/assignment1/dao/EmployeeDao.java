package com.antra.assignment1.dao;

import com.antra.assignment1.data.Department;
import com.antra.assignment1.data.Employee;

import java.util.List;

public interface EmployeeDao {
    public void addEmployee(Employee employee);

    public void addEmployee(Employee employee, Department department);

    public List<Employee> findAllEmployees();
}
