package com.luv2code.springdemo.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;

	/*@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}*/
	

	@Override
	@Transactional
	public void saveCustomer(Customer thecustomer) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(thecustomer);
	}

	
	@Override
	@Transactional
	public Customer getCustomer(int id) {
		//get the customer from the database
		Customer theCustomer = customerDAO.getCustomer(id);
		return theCustomer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomer(String name) {
		List<Customer> theCustomers = customerDAO.searchCustomers(name);
		return theCustomers;
	}


	@Override
	@Transactional
	public List<Customer> getCustomers(int theSortField) {
		return customerDAO.getCustomers(theSortField);
	}

}
