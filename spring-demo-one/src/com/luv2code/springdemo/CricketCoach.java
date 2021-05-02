package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	 private String email;
	 private String team;
	
	public CricketCoach() {
		System.out.println("CricketCoach: inside no args constructor");
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortunes() {
		// TODO Auto-generated method stub
		return "In Cricket "+fortuneService.getFortune();
	}

	//on setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Spring calling Setter method in CricketCoach");
		this.fortuneService = fortuneService;
	}

	public void setEmail(String email) {
		System.out.println("Spring calling Setter method in CricketCoach:: setEmail() ");
		this.email = email;
	}

	public void setTeam(String team) {
		System.out.println("Spring calling Setter method in CricketCoach:: setTeam() ");
		this.team = team;
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}	
}
