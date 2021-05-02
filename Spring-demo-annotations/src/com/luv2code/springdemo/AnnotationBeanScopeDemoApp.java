package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//load spring config file 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve the bean from container
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach",Coach.class);
		System.out.println("Pointing to the same object : "+ theCoach.equals(alphaCoach));
		System.out.println("Memory Location for theCoach: "+theCoach);
		System.out.println("Memory Location for alphaCoach: "+alphaCoach);
		
		context.close();
	}

}
