package com.hcl.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext("EmployeeConfig.class");
		Employee employee = ioc.getBean(Employee.class);
		employee.setId(2222);
		employee.setName("Raman");
		employee.setSalary(50452.24);
		System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getSalary());

	}

}
