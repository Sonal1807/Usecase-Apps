package com.hcl.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext("com.hcl.spring");
		Employee employee = ioc.getBean("emp", Employee.class);
		System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getSalary());

	}

}
