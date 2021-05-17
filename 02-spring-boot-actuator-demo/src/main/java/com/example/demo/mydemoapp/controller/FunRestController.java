package com.example.demo.mydemoapp.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	//expose "/" that return "Hello world"
	@GetMapping("/")
	public String sayHello() {
		return "Hello world! time on server is " + LocalDateTime.now();
	}
	
	//expose a new endpoint for "WorkOut"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}
	
	//expose a new endpoint for "fortune"
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucky day";
	}
}
