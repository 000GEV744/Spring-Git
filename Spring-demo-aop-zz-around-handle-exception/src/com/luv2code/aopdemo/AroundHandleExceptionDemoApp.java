package com.luv2code.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	
	public static void main(String[] args) throws Exception  {
		
		//read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
        
		
		myLogger.info("\nMain Program: AroundDemoApp");
		
		myLogger.info("Calling Fortune");
		
		boolean tripWire = true;
		
		String data = theFortuneService.getFortune(tripWire);
		
		myLogger.info("\nMy Fortune is: "+data);
		
		myLogger.info("FINISH");
		
        //close the context
		context.close();
	}
}
