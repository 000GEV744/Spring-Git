package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			//start a transaction
			session.beginTransaction();
			
			//query the students 
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display the students
			displayStudents(theStudents);
			
			//find the student whose name is "Doe"
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			//display Students
			System.out.println("\n\nStudents who have last name of Doe");
			displayStudents(theStudents);
			
			
			//query students: lastName = 'Doe' OR firstName = 'Daffy'
			theStudents = session.createQuery("from Student s where"
							+" s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
			System.out.println("\n\nStudents who have last name of Doe OR first name is Daffy");
			displayStudents(theStudents);
			
			//query to check whether email ends with '%gmail.com'
			theStudents = session.createQuery("from Student s where "+
							"s.email LIKE '%gmail.com'").getResultList();
			System.out.println("\n\nStudents whose email ends with '%gmail.com' ");
			displayStudents(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student theStudent : theStudents) {
			System.out.println(theStudent);
		}
	}

}
