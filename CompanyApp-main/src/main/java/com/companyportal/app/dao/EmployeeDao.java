package com.companyportal.app.dao;

import java.util.List;

import com.companyportal.app.entity.Employee;

public interface EmployeeDao {

	void saveOrUpdateEmployee(Employee employee);

	List<Employee> getEmployeesData();

	void deleteEmployeeData(Employee employee);

	Employee getEmployeeById(int employeeId);

	List<Employee> searchEmployeeByName(String employeeName);

}