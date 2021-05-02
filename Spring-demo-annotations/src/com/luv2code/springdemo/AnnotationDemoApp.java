package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//read the spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
				
	    //retrive the bean from the spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		//call a method on the bean 
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortunes());
		//close the context
		context.close();
	}

}
