package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	    
	    //Get Employee by id
	    @GetMapping("/employees/{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
	    	Employee employee = employeeRepository.findById(id).
	    			orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id : " +id));
	    	return ResponseEntity.ok(employee);	
	    }
	    
	    //update employee
	    @PutMapping("/employees/{id}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id ,@RequestBody Employee employeeDetails){
	    	
	    	Employee employee = employeeRepository.findById(id).
	    			orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id : " +id));
	    	
	    	employee.setFirst_name(employeeDetails.getFirst_name());
	    	employee.setLast_name(employeeDetails.getLast_name());
	    	employee.setEmailID(employeeDetails.getEmailID());
	    	
	    	Employee updateEmployee = employeeRepository.save(employee);
	    	return ResponseEntity.ok(updateEmployee);
	    	
	    }
	    
}

