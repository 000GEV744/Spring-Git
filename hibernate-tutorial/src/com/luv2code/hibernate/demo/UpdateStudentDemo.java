package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
		
		//create session
		
		
		try {
			int studentId = 1;
			
			//start a transaction
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retreive student based on the id: primary key
			System.out.println("\nGetting student with id: "+studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Get Complete: "+myStudent);
			
			System.out.println("Updating student ...");
			myStudent.setFirstName("Scooby");

			//commit transaction
			session.getTransaction().commit();
			
			//New Code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students 
			System.out.println("update email for all students");
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
		
	}

}
