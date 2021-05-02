package com.luv2code.springdemo;

public class BaseballCoach implements Coach{

	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 min on battig practice";
	}

	@Override
	public String getDailyFortunes() {
		return fortuneService.getFortune();
	}
}
