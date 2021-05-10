package com.luv2code.aopdemo.aspect;


import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		//print out method we are advising on
		//print out which method we are advising on
				String method = theProceedingJoinPoint.getSignature().toShortString();
				myLogger.info("\n=======>>>> Executing @Around on method: "+method);			
			
		//get begin timestamp
		long begin = System.currentTimeMillis();
						
		//now, let's execute the method
		Object result = null;
		
		try{
			result = theProceedingJoinPoint.proceed();
		}
		catch (Exception e) {
			
			//log the exception
			myLogger.warning(e.getMessage());
			/*//give user a custom message
			result = "Major Accident! but no Worries,"
					+ "your orivate AOP Helicopter is on the way!";*/
			
			//rethrow Exception
			throw e;
		}
		
		//get end timestamp
		long end = System.currentTimeMillis();
		
		//compute duration and display it
		long duration = end-begin;
		myLogger.info("\n====>> Duration: "+duration/1000.0+" seconds");
		return result;
		
	}
	
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=======>>>> Executing @After (Finally) on method: "+method);			
	}

	
	@AfterThrowing(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))",
			throwing = "theExc"
			)
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=======>>>> Executing @AfterThrowing on method: "+method);
				
		//log the Exception
		myLogger.info("\n=====>>>> result is: "+theExc);
	}
	
	//add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=======>>>> Executing @AfterReturning on method: "+method);
		
		//print out the results of the method call
		myLogger.info("\n=====>>>> result is: "+result);
		
		//let's post-process the data...leyt's modify it
		
		//convert the account names to uppercase.
		convertAccoutnNamesToUpperCase(result);
		
		//print out the results of the method call
		myLogger.info("\n=====>>>> result is: "+result);
	}
	
	
	
	private void convertAccoutnNamesToUpperCase(List<Account> result) {
		//loop through accounts 
		for(Account tempAccount: result) {
			
			//get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			//update the name of the account
			tempAccount.setName(theUpperName);
		}
		
		//get uppercase version of name
		
		//update the name of the account
		
	}



	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n=======>>>> Executing @Before Advice on addAccount()");
	
		//display the method signature 
		MethodSignature methSig = (MethodSignature)theJoinPoint.getSignature();
		myLogger.info("Method: "+methSig);
		
		//display the method arguments 
		Object[] args = theJoinPoint.getArgs();
		
		//loop thru args
		for(Object tempArg : args) {
			myLogger.info(tempArg.toString());
			if(tempArg instanceof Account) {
				//downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				myLogger.info("account name: "+theAccount.getName());
				myLogger.info("account name: "+theAccount.getLevel());
				
			}
		}
	}

}
 