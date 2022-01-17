package com.hcl.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("com/hcl/resources/beans-config.xml");
		Employee employee = ioc.getBean("emp", Employee.class);
		System.out.println(employee.getId() + "\n" + employee.getName() + "\n" + employee.getSalary() + "\n"
				+ employee.getProject() + "\n" + "Roles are" + employee.getRoles());
		System.out.println(employee.hashCode());
		Employee employee2 = ioc.getBean("emp", Employee.class);
		System.out.println(employee2.hashCode());
		ioc.registerShutdownHook();

	}

}
