package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.util.SortUtils;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory 
	@Autowired
	private SessionFactory sessionFactory;

	/*@Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate session 
		Session session = sessionFactory.getCurrentSession();
		
		//create a query, sort by last name, execute query and get result list
		List<Customer> theCustomers = 
				session.createQuery("from Customer order by lastName", Customer.class).getResultList();
		
		//return the results
		return theCustomers;
	}*/

	@Override
	public void saveCustomer(Customer thecustomer) {
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//save the customer ...finally
		session.saveOrUpdate(thecustomer);
	}

	@Override
	public Customer getCustomer(int id) {
		
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//now retrieve from the database using the primary key
		Customer theCustomer = session.get(Customer.class, id);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int id) {
		
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		//now Delete the object with given primary key
		Query theQuery =
				session.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", id);
		theQuery.executeUpdate();
	}

	@Override
	@Transactional
    public List<Customer> searchCustomers(String theSearchName) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
                
        // return the results        
        return customers;
        
    }

	@Override
	@Transactional
	public List<Customer> getCustomers(int theSortField) {
		
		// get the current hibernate session
        Session session = sessionFactory.getCurrentSession();
        
        //determine sort field
        String theFieldName = null;
        
        switch(theSortField) {
        
        case SortUtils.EMAIL:
        	theFieldName ="email";
        	break;
        case SortUtils.FIRST_NAME:
        	theFieldName="firstName";
        	break;
        case SortUtils.LAST_NAME:
        	theFieldName="lastName";
        	break; 
        default:
        	//if nothing matches the default to sort by LastName
        	theFieldName = "lastName";
        }
        
        //create the Query
        String queryString = "from Customer order by "+theFieldName;
        Query<Customer> query = session.createQuery(queryString,Customer.class);
        
        //execute query and get result list
        List<Customer> customers = query.getResultList();
        
		return customers;
	}
}
