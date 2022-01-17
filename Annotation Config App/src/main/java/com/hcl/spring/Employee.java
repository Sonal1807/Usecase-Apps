package com.hcl.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("emp")
@Scope(scopeName = "prototype")
public class Employee implements InitializingBean, DisposableBean {

	@Value("1111")
	private int id;
	@Value("Rajat")
	private String name;
	@Value("45600.56")
	private double salary;
	@Autowired
	private Project project;

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy method is invoked");

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init method is invoked");

	}

}
