package com.example.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public  EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		//create a query
		Query theQuery = entityManager.createQuery("from Employee");
		
		//execute query and get result list
		List<Employee> employee = theQuery.getResultList();
		
		//return the results
		return employee;
	}

	@Override
	public Employee findById(int theId) {
		
		//get the employee
		Employee theEmployee = 
				entityManager.find(Employee.class, theId);
				
		//return employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		//save or update the employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		//update with id from db  ..... so we can get generated id for save/insert
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {

		//delete object with primary key 
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}
	
	
}
