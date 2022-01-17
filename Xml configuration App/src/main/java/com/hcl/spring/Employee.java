package com.hcl.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private List<String> roles;
	private Project project;

	public int getId() {
		return id;
	}

	@Required
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Employee [roles=" + roles + "]";
	}

	public void employeeInit() {
		System.out.println("Init method is called");
	}

	public void employeeDestroy() {
		System.out.println("Destroy method is called");
	}

}
