package com.luv2code.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

	String[] fortunes = {"Today is your lucky day!",
			"It's gonna be a big day for you",
			"you will get a really good news today"};
	
	@Override
	public String getFortune() {
		Random rand = new Random();
		return fortunes[rand.nextInt(fortunes.length)];
		
	}

}
