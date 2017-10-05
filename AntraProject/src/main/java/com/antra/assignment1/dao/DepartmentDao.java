package com.antra.assignment1.dao;

import com.antra.assignment1.data.Department;

import java.util.List;

public interface DepartmentDao {
    public void addDepartment(Department department);

    public List<Department> findAllDepartments();
}
