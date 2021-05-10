package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {

		//simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//return a fortune
		return "Expected Heavy Traffic this morning";
	}

	
	public String getFortune(boolean tripWire) throws Exception {
		
		if(tripWire) {
			throw new Exception("Major Accident! Highway is closed");
		}
		return getFortune();
	}
}
