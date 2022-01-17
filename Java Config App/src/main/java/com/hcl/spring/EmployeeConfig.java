package com.hcl.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.hcl.spring")
public class EmployeeConfig {

	@Bean
	public Employee getEmployeeBean() {
		return new Employee();
	}

}
