package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
        
		
		System.out.println("\nMain Program: AroundDemoApp");
		
		System.out.println("Calling Fortune");
		
		String data = theFortuneService.getFortune();
		
		System.out.println("\nMy Fortune is: "+data);
		
		System.out.println("FINISH");
		
        //close the context
		context.close();
	}
}
