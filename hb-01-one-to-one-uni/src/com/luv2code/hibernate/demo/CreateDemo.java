package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

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
			//create the Object 
			/*Instructor ins1 = new Instructor("Chad", "Darby", "darby@luv2code.com");
			InstructorDetail insDetail1 = 
					new InstructorDetail("https://www.luv2code.com/youtube","Luv 2 Code!!");
			
			//associate the object
			ins1.setInstructorDetails(insDetail1);*/
			Instructor ins1 = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
			InstructorDetail insDetail1 = 
					new InstructorDetail("https://www.youtube.com","Guitar");
			
			//associate the object
			ins1.setInstructorDetails(insDetail1);
			
			//start a transaction
			session.beginTransaction();
			
			//save the instructor
			//Note: this will also save the details oject 
			//because of CascadeType.All
			session.save(ins1);

			System.out.println("Saving Instructor: "+ins1);
			System.out.println("Details: "+insDetail1);
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
		
	}

}
