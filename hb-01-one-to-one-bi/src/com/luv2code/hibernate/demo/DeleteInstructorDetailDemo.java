package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			
			//get the instructor detail Object
			int theId = 3;
			InstructorDetail tempInstructorDetail =
					session.get(InstructorDetail.class, theId);
			
			//print the instructor detail
			System.out.println("temoInstructorDetail: "+tempInstructorDetail);
			
			//also print the associated instructor
			System.out.println("the associated Instructor: "+tempInstructorDetail.getInstructor());

			//now let's delete the instructor detail
			// remove the associated object reference
			//break bidirectional link 
			tempInstructorDetail.getInstructor().setInstructorDetails(null);
			System.out.println("Deleteing tempInstructorDetail: "+tempInstructorDetail);
			
			session.delete(tempInstructorDetail);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//handle connection leak issue
			connectionsClose(factory, session);
		}
		
	}

	private static void connectionsClose(SessionFactory factory, Session session) {
		session.close();
		factory.close();
	}

}
