package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionDemo {

	public static void main(String[] args) {
		//load the spring configuration file 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		CricketCoach myCricketCoach = (CricketCoach) context.getBean("myCricketCoach");
		
		System.out.println(myCricketCoach.getDailyFortunes());
		System.out.println(myCricketCoach.getDailyWorkout());
		System.out.println(myCricketCoach.getEmail());
		System.out.println(myCricketCoach.getTeam());
		 
		context.close();
	}

}
