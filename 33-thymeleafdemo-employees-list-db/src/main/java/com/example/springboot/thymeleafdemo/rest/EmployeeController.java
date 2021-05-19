package com.example.springboot.thymeleafdemo.rest;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.thymeleafdemo.entity.Employee;
import com.example.springboot.thymeleafdemo.service.EmployeeService;



@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	//add mapping for "/list"
	@GetMapping("/list")
	public String getEmployeesList(Model m) {
		
		List<Employee> theEmployees = employeeService.findAll();
		
		//add to the spring model
		m.addAttribute("employees",theEmployees);
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model m) {
		Employee theEmployee = new Employee();
		m.addAttribute("employee",theEmployee);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		//save the employee
		employeeService.save(theEmployee);
		//use a redirect to prevent duplicate submission
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int empId,
			Model m) {
		
		//get the employee from the service 
		Employee theEmployee = employeeService.findById(empId);
		
		//set the employee as a model attribute to pre-populate the form
		m.addAttribute("employee", theEmployee);
		
		//send over to our form
		return "employees/employee-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int empId) {
		
		//get the employee from the service 
		Employee theEmployee = employeeService.findById(empId);
		if(theEmployee!=null)
			employeeService.deleteById(empId);
		//use a redirect to prevent duplicate submission
		return "redirect:/employees/list";
	}
}
