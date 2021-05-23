package com.example.xml.demo.xmldemo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.xml.demo.xmldemo.model.UserRest;
import com.example.xml.demo.xmldemo.services.UserServices;

@RestController
@RequestMapping("/api")
public class XmlController {

	@Autowired
	private UserServices userService;
	
	@GetMapping(path = "/user",produces = {MediaType.APPLICATION_XML_VALUE})
	public List<UserRest> showUsers(){
		return userService.getAllUsers();
	}
	
}
