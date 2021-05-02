package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//read the spring config file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportsConfig.class);
				
	    //retrive the bean from the spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		//call a method on the bean 
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortunes());
		//close the context
		context.close();
	}

}
