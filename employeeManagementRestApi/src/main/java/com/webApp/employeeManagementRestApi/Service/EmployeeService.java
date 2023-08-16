package com.webApp.employeeManagementRestApi.Service;

import java.util.List;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.webApp.employeeManagementRestApi.Entity.Employee;
import com.webApp.employeeManagementRestApi.Repository.EmployeeRepo;
import com.webApp.employeeManagementRestApi.ServiceInterface.EmployeeSreviceInterface;

@Service
public class EmployeeService implements EmployeeSreviceInterface {

	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public Employee addemployee(Employee employee) {

		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {

		return employeeRepo.findAll();
	}

	@Override
	public Employee employeeById(int empid) {
		// TODO Auto-generated method stub
		return employeeRepo.findById(empid).get();
	}

	@Override
	public Employee updateEmployee(int empid, Employee emp1) {
		Employee dbemp = employeeById(empid);
		dbemp.setEmail(emp1.getEmail());
		dbemp.setFirstName(emp1.getFirstName());
		dbemp.setLastName(emp1.getLastName());
		return employeeRepo.save(dbemp);

	}

	@Override
	public void deleteEmployee(int empid) {
		employeeRepo.deleteById(empid);

	}

	@Override
	public List<Employee> sortByFirstName(Direction direction) {

		return employeeRepo.findAll(Sort.by(direction, "firstName"));
	}

	@Override
	public List<Employee> getfirstNameList(String firstname) {
		Employee emp1 = new Employee();
		emp1.setFirstName(firstname);

		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("lastName", "email", "id");

		org.springframework.data.domain.Example<Employee> example = org.springframework.data.domain.Example.of(emp1,
				matcher);
		return employeeRepo.findAll(example);
	}

}
