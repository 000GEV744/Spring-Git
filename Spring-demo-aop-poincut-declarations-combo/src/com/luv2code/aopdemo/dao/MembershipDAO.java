package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	/*public void addSillyMember() {
		System.out.println(getClass()+" Doing Stuff: Adding a membership account");
	}*/
	public boolean addSillyMember() {
		System.out.println(getClass()+" Doing Stuff: Adding a membership account");
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass()+": I am goint to sleep");
	}
}
