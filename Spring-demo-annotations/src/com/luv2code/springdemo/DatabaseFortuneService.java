package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

	@Override
	public String getYourDailyFortune() {
		// TODO Auto-generated method stub
		return "DatabaseFortuneService: WOHOO It's your best day!";
	}

}
