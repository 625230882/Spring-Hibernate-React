package com.antra.assignment1.service;

import com.antra.assignment1.data.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee e);

    List<Employee> getAllEmployees();
}
