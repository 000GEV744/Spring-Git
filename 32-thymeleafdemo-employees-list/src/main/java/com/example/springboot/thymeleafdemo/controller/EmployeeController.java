package com.example.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	//load the employee data 
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		
		//create employee
		Employee emp1 = new Employee(1, "Leslie", "Andrews", "leslie@luv2code.com");
		Employee emp2 = new Employee(2, "Emma", "Baumgarten", "emma@luv2code.com");
		Employee emp3 = new Employee(3, "Avani", "Gupta", "avni@luv2code.com");
		Employee emp4 = new Employee(4, "Madhu", "Patel", "madhu@luv2code.com");
		
		//create the list
		theEmployees = new ArrayList<Employee>();
		
		//add to the list
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
		theEmployees.add(emp4);
	
	}
	
	//add mapping for "/list"
	@GetMapping("/list")
	public String getEmployeesList(Model m) {
		
		//add to the spring model
		m.addAttribute("employees",theEmployees);
		return "list-employees";
	}
}
