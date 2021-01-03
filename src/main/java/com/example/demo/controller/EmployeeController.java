package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	 @Autowired
	    private EmployeeRepository employeeRepository;

	    //get all employees
	    @GetMapping("/employees")
	    public List<Employee> getAllEmployees(){
	        return employeeRepository.findAll();
	    }
	    //Create Employee
	    @PostMapping("/employees")
	    public Employee createEmployee(@RequestBody Employee employee) {
	    	return employeeRepository.save(employee);
	    }
}
