package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {



		//create session factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Course.class)
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			int theId = 1;
			
			//get the instructor from the db
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("luv2code: Instructor: "+tempInstructor);

			//get course for the instructor ---OPTION 1
			System.out.println("luv2code: courses: "+tempInstructor.getCourses());
			
			
			//commit transaction
			session.getTransaction().commit();

			//close the session
			session.close();
			
			System.out.println("luv2code: session is closed now...\n\n\n\n");
			//since courses are lazy loaded ...this should fail
			
			//get course for the instructor
			System.out.println("luv2code: courses: "+tempInstructor.getCourses());
			
			
			
			System.out.println("luv2code: Done!");		
		}
		finally {
			
			//add clean up code 
			session.close();
			factory.close();
		}
		

	}

}
