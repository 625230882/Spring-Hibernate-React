package com.antra.assignment1.data;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="department")
public class Department implements Serializable {
	private static final long serialVersionUID = 2034058313623401547L;
	private int id;
	private String name;
	private String email;
	private Set<Employee> employees;

	public Department() {}

	public Department(String name, String email) {
		this.name = name;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "dept_id")
	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	@Column(name = "dept_name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "dept_email")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy = "department")
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
