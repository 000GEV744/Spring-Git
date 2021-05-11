package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//setup Logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	//do the same thing for service and dao package
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void fordaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || fordaoPackage()")
	private void forAppFlow() {}
	
	//add @Before advice
	@Before("forAppFlow()")
	private void before(JoinPoint theJoinpoint) {
		
		//display method we are calling 
		String theMethod = theJoinpoint.getSignature().toShortString();
		myLogger.info("===>> in @before: calling method: "+theMethod);
		
		//display the argumeents to the method
		Object[] args = theJoinpoint.getArgs();
		
		//loop thru and display args
		for(Object tempArgs : args) {
			myLogger.info("===>> argument: "+tempArgs);
		}
		
	}
	
	
	//add @AfterReturning Advice
	@AfterReturning(
			pointcut = "forAppFlow()",
		returning = "theResult"
			)
	public void afterRetruning(JoinPoint theJoinpoint, Object theResult) {
		
		//display the method we are returning from
		String theMethod = theJoinpoint.getSignature().toShortString();
		myLogger.info("===>> in @AfterReturning: calling method: "+theMethod);
		
		//display the data returned
		myLogger.info("====>>> result: "+theResult);
				
	}
	
}
