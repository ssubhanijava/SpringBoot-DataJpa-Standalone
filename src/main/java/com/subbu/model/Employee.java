package com.subbu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Emp_tbl")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "Emp_Name")
	private String name;
	@Column(name = "Emp_Email")
	private String email;
	@Column(name = "Emp_Education")
	private String eduation;

	public Employee(String name, String email, String eduation) {
		super();
		this.name = name;
		this.email = email;
		this.eduation = eduation;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEduation() {
		return eduation;
	}

	public void setEduation(String eduation) {
		this.eduation = eduation;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", eduation=" + eduation + "]";
	}

}
