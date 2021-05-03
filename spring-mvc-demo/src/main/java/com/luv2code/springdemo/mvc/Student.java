package com.luv2code.springdemo.mvc;

import java.util.ArrayList;
import java.util.LinkedHashMap;


public class Student {

	String firstName;
	String lastName;
	String country;
	String favoriteLanguage;
	ArrayList<String> operatingSystems;
	
	
	private LinkedHashMap<String, String> countryOptions;
	
	public Student() {
		//populate country options: used ISO country code
		countryOptions = new LinkedHashMap<String, String>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		countryOptions.put("US", "USA");
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public void setFavoriteLanguage(String favouriteLanguage) {
		this.favoriteLanguage = favouriteLanguage;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public ArrayList<String> getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(ArrayList<String> operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
	
	
	
	
}
