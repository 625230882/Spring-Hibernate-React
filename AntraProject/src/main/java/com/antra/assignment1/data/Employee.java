package com.antra.assignment1.data;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="employee")
public class Employee implements Serializable{
	private static final long serialVersionUID = 2034058313623401547L;
	private String firstName;
	private String lastName;
	private int age;
	private int id;
	private Department department;

	public Employee() {
		
	}
	
	public Employee(String fN, String lN, int age) {
		this.firstName = fN;
		this.lastName = lN;
		this.age = age;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "emp_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "age")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "department_id")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
