package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;

	@Value("${foo.email}")
	private String emailAddress;

	@Value("${foo.team}") //property level Injection
	private String team;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meter as a warm up";
	}

	@Override
	public String getDailyFortunes() {
		return fortuneService.getYourDailyFortune();
	}

	
	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}
	
	
	

}
