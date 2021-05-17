package com.example.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public  EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {

		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query 
		Query<Employee> theQuery = 
				currentSession.createQuery("from Employee", Employee.class);
		
		//execute query and get result list
		List<Employee> empList = theQuery.getResultList();
		
		//return the results
		
		return empList;
	}

	@Override
	public Employee findById(int theId) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		Employee theEmployee = currentSession.get(Employee.class,theId);
		
		//return the employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save employee
		currentSession.saveOrUpdate(theEmployee);	
	}

	@Override
	public void deleteById(int theId) {

		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete object with primary key
		Query theQuery = currentSession.createQuery(
				"delete from Employee where id=:employeeID");
		theQuery.setParameter("employeeID", theId);
		theQuery.executeUpdate();

	}

}
