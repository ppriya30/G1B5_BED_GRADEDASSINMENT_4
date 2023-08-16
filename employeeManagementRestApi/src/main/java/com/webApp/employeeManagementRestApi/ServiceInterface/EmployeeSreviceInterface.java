package com.webApp.employeeManagementRestApi.ServiceInterface;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.webApp.employeeManagementRestApi.Entity.Employee;

@Service
public interface EmployeeSreviceInterface {

	Employee addemployee(Employee employee);

	List<Employee> getAllEmployee();

	Employee employeeById(int empid);

	Employee updateEmployee(int empid, Employee emp1);

	void deleteEmployee(int empid);

	List<Employee> sortByFirstName(Direction direction);

	List<Employee> getfirstNameList(String firstname);

}