package com.antra.assignment1.service;

import com.antra.assignment1.data.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ServiceTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/application-context.xml");
        DepartmentService departmentService = (DepartmentService) applicationContext.getBean("departmentServiceImpl");
        List<Department> res = departmentService.loadDepartments();
        //res.stream().forEach(d -> {d.ge}));
    }
}
