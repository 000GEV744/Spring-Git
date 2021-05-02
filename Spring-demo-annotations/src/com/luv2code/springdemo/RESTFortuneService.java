package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {

	@Override
	public String getYourDailyFortune() {
		// TODO Auto-generated method stub
		return "RestFortuneService = today is your lucky day!";
	}

}
