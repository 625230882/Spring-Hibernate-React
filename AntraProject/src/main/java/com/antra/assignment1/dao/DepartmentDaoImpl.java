package com.antra.assignment1.dao;

import com.antra.assignment1.data.Department;
import com.antra.assignment1.data.Employee;
import com.antra.assignment1.service.DepartmentServiceImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao{

    @PersistenceContext
    EntityManager em;

    @Override
    public void addDepartment(Department department) {
        em.persist(department);
    }

    @Override
    public List<Department> findAllDepartments() {
        Query query = em.createQuery("select distinct d from Department d");
        List<Department> list = query.getResultList();
        list.stream().forEach(d -> {d.getEmployees().stream().forEach(e -> System.out.println(e.getFirstName()));});
        return query.getResultList();
    }

}
