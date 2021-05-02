package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//load the sprig config file 
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope_applicationContext2.xml");
		
		//retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach",Coach.class);
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		System.out.println(theCoach.equals(alphaCoach));
		
		//close the context
		context.close();
	}

}
