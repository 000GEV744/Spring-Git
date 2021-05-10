package com.luv2code.aopdemo.aspect;


import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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

	
	
	//add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=======>>>> Executing @AfterReturning on method: "+method);
		
		//print out the results of the method call
		System.out.println("\n=====>>>> result is: "+result);
		
		//let's post-process the data...leyt's modify it
		
		//convert the account names to uppercase.
		convertAccoutnNamesToUpperCase(result);
		
		//print out the results of the method call
		System.out.println("\n=====>>>> result is: "+result);
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
		System.out.println("\n=======>>>> Executing @Before Advice on addAccount()");
	
		//display the method signature 
		MethodSignature methSig = (MethodSignature)theJoinPoint.getSignature();
		System.out.println("Method: "+methSig);
		
		//display the method arguments 
		Object[] args = theJoinPoint.getArgs();
		
		//loop thru args
		for(Object tempArg : args) {
			System.out.println(tempArg);
			if(tempArg instanceof Account) {
				//downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("account name: "+theAccount.getName());
				System.out.println("account name: "+theAccount.getLevel());
				
			}
		}
	}

}
 