package com.webApp.employeeManagementRestApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webApp.employeeManagementRestApi.Entity.Employee;
import com.webApp.employeeManagementRestApi.ServiceInterface.EmployeeSreviceInterface;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	private EmployeeSreviceInterface employeeService;

	@PostMapping("/addemployee")
	public Employee addemployee(@RequestBody Employee employee) {
		return employeeService.addemployee(employee);
	}

	@GetMapping("/list")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/employeeById")
	public Employee employeeById(@RequestParam("emp_id") int empid) {

		return employeeService.employeeById(empid);
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestParam("emp_id") int empid, @RequestBody Employee emp1) {
		return employeeService.updateEmployee(empid, emp1);
	}

	@DeleteMapping("/delete")
	public String deleteEmployee(@RequestParam("emp_id") int empid) {

		employeeService.deleteEmployee(empid);
		return "employee info deleted";
	}

	@GetMapping("/sortByFirstName")
	public List<Employee> sortByFirstName(@RequestParam("order") Direction direction) {
		return employeeService.sortByFirstName(direction);
	}

	@GetMapping("/getfirstNameList")
	public List<Employee> getfirstNameList(@RequestParam("fname") String firstname) {
		return employeeService.getfirstNameList(firstname);
	}

}
