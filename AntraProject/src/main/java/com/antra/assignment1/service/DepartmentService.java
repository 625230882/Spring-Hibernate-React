package com.antra.assignment1.service;

import com.antra.assignment1.data.Department;

import java.util.List;

public interface DepartmentService {
    public void addDept(Department department);

    public List<Department> loadDepartments();
}
