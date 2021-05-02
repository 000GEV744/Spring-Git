package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//read the spring config file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportsConfig.class);
				
	    //retrive the bean from the spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		//call a method on the bean 
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortunes());
		
		//call our new Swim coach methods...  has the properties values injected
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		//close the context
		context.close();
	}

}
