package com.example.xml.demo.xmldemo.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.xml.demo.xmldemo.model.UserRest;

@Service
public class UserServices {

	private List<UserRest> users;
	
	@PostConstruct
	private List<UserRest> fetchUsers(){
		users = new ArrayList<UserRest>();
		UserRest u1 = new UserRest("Anuj","Singh","anuj60360@gmail.com");
		UserRest u2 = new UserRest("Alex","Zeason","alex37@gmail.com");
		UserRest u3 = new UserRest("Milia","Anderson","milia39@gmail.com");
		UserRest u4 = new UserRest("Chad","Darby","chad283@gmail.com");
		UserRest u5 = new UserRest("Recky","Elian","recky20a@gmail.com");
		
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
		users.add(u5);
		
		return users;
	}
	
	public List<UserRest> getAllUsers(){
		return fetchUsers();
	}
	
	
}
