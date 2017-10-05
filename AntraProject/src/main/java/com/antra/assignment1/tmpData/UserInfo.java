package com.antra.assignment1.tmpData;

import java.util.concurrent.ConcurrentHashMap;

import com.antra.assignment1.data.Department;
import com.antra.assignment1.data.Department;
import com.antra.assignment1.data.Employee;

public class UserInfo {
	private final static String userName = "a";
	private final static String password = "b";
	
	private final static ConcurrentHashMap<String, Employee> employeeInfo = new ConcurrentHashMap<>();
	private final static ConcurrentHashMap<Department, String[]> deptInfo = new ConcurrentHashMap<>();
	
	private UserInfo() {
		
	}
	
	public static ConcurrentHashMap<String, Employee> getEmployeeInfo() {
		return employeeInfo;
	}
	
	public static ConcurrentHashMap<Department, String[]> getDeptInfo() {
		return deptInfo;
	}
	
	public static String getUserName() {
		return userName;
	}
	
	public static String getPassword() {
		return password;
	}
}
