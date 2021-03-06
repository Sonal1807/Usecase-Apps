package com.companyportal.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyportal.app.dao.EmployeeDao;
import com.companyportal.app.entity.Employee;
import com.companyportal.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void saveOrUpdateEmployee(Employee employee) {
		employeeDao.saveOrUpdateEmployee(employee);
	}

	@Override
	public List<Employee> getEmployeesData() {

		return employeeDao.getEmployeesData();
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeDao.deleteEmployeeData(employee);

	}

	@Override
	public Employee getEmployeeById(int employeeId) {

		return employeeDao.getEmployeeById(employeeId);
	}

	@Override
	public List<Employee> searchEmployeebyName(String employeeName) {

		return employeeDao.searchEmployeeByName(employeeName);
	}

}