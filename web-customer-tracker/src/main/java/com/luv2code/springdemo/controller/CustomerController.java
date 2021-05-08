package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import com.luv2code.springdemo.util.SortUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject our customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model model, @RequestParam(required = false) String sort)
	{
		//get the customers froom the service 
		List<Customer> theCustomers = null;
		
		//check for sort field
		if(sort!=null) {
			int theSortField = Integer.parseInt(sort);
			theCustomers = customerService.getCustomers(theSortField);
		}
		else {
			//no sort field provided ... default to sorting by the last name
			theCustomers = customerService.getCustomers(SortUtils.LAST_NAME);
		}
		
		//add teh customers to the model
		model.addAttribute("customers", theCustomers);
		
        return "list-customers";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String addCustomer(Model model)
	{
        model.addAttribute("customer",new Customer());
        return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer thecustomer) {
		
		//save the customer using our service
		customerService.saveCustomer(thecustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") int id, Model model) {
		
		//get the customer from the database
		Customer theCustomer = customerService.getCustomer(id);
		
		//set customer as a model attribute to pre-populate the form
		model.addAttribute("customer",theCustomer);
		
		//send over to actual form for update
		return "customer-form";
	}
	
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		
		//delete the customer from the database
		customerService.deleteCustomer(id);
				
		//send over to actual form for update
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String name, Model model) {
		
		//search customers from the service
		List<Customer> theCustomers = customerService.searchCustomer(name);
		
		//add the customer to the model
		model.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
}
