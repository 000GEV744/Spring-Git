package com.luv2code.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getYourDailyFortune() {
		return "Today is a sad day";
	}

}
