package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

	
	private FortuneService fortuneService;
	
	
	public TennisCoach() {
		System.out.println(">> inside the default contructor");
	}
	

	@Autowired
	public TennisCoach(@Qualifier("randomFortuneService")FortuneService fortuneService) {
		System.out.println(">> TennisCoach: inside constructor using @autowired and @Qualifier");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortunes() {
		// TODO Auto-generated method stub
		return fortuneService.getYourDailyFortune();
	}

	//define a setter method for injecting the fortuneService
	/*@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/

	/*@Autowired
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println(">> tennisCoach: inside doSomeCrazyStuff() method");
		this.fortuneService = fortuneService;
	}*/
	
	//define my init method 
	@PostConstruct
	public void doMyStartupstuff() {
		System.out.println(">> TennisCoach: inside DoMyStartupStuff");
	}
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside doMyCleanupStuff");
	}
	
	//define my destroy method
	

}
