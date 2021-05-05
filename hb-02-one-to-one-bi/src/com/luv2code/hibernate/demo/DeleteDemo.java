package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			//start a transaction
			session.beginTransaction();
			

			//get the instructor by their primary key 
			int theId = 1;
			Instructor tempInstructor = 
					session.get(Instructor.class, theId);
			
			System.out.println("Fount Instructor: "+tempInstructor);
			if(tempInstructor!=null) {
				System.out.println("Deleting the Instructor: "+tempInstructor);
				
				//this will also delete the details object as well
				//because of Cascade.All
				session.delete(tempInstructor); 
			}
			//delete the instructor
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
		
	}

}
