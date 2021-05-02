package com.luv2code.springdemo;

import org.springframework.beans.factory.DisposableBean;

public class TrackCoach implements Coach, DisposableBean {

	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5 km";
	}

	@Override
	public String getDailyFortunes() {
		//use my fortuneService to get a fortune
		return "Just do it "+fortuneService.getFortune();
	}
	
	//add an init method
	public void doMyStartupStuff() {
		System.out.println("Track Coach: inside method doMyStartupStuff");
	}
	//add a destroy method
	/*public void doMyCleanupStuff() {
	System.out.println("Track Coach: inside method doMyCleanupStuff");
    }*/

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TrackCoach: inside method doMyCleanupStuffYoYo");		
	}

}
