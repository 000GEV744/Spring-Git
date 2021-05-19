package com.example.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	//creating a mapping for "/hello"
	@GetMapping("/hello")
	public String sayHellow(Model theModel)
	{
		theModel.addAttribute("theDate", new java.util.Date());
		return "helloworld";
	}
}
