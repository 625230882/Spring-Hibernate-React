package com.antra.assignment1.dao;

import com.antra.assignment1.data.Department;
import com.antra.assignment1.data.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @PersistenceContext
    EntityManager em;

    @Override
    public void addEmployee(Employee employee, Department department) {
        employee.setDepartment(department);
        em.persist(employee);
    }

    @Override
    public void addEmployee(Employee employee) {
        Query query = em.createQuery("Select d from Department d");
        List<Department> list = query.getResultList();
        employee.setDepartment(list.get(0));
        em.persist(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        Query query = em.createQuery("Select distinct Object(e) from Employee e");
        return query.getResultList();
    }
}
