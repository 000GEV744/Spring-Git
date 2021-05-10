package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	//add a new method: findAccounts()
	public List<Account> findAccount(){
		List<Account> myAccounts = new ArrayList<Account>();
		
		//create sample accounts 
		Account temp1 = new Account("John","Silver");
		Account temp2 = new Account("Madhu","Platinum");
		Account temp3 = new Account("Lica","Gold");
		Account temp4 = new Account("Jeremy","Bronze");

		//add them to our accounts lists
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		myAccounts.add(temp4);
		
		return myAccounts;
	}
	
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass()+": Doing my DB work: Adding an Account");
	}
	
	public boolean dowork() {
		System.out.println(getClass()+": doWork()");
		return true;
	}

	public String getName() {
		System.out.println(getClass()+": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+": setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+": getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
}
