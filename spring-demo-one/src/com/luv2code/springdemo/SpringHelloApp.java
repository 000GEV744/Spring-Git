package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//load the spring configuration file
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
				
		//retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		//dependency injection 
		System.out.println(theCoach.getDailyFortunes());
		context.close();
	}

}
