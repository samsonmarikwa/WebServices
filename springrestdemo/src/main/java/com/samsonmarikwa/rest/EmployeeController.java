package com.samsonmarikwa.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@GetMapping("/employee")
	public Employee getEmployee() {
		Employee employee = new Employee();
		employee.setFirstName("Samson");
		employee.setLastName("Marikwa");
		return employee;
	}
}
