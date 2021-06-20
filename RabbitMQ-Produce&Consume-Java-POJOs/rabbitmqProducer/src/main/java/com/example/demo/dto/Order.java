package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
public class Order {
	private String orderId;
	private String name;
	private int qnty;
	private double price;
	
	public Order(String name, int qnty, double price) {
		this.name = name;
		this.qnty = qnty;
		this.price = price;
	}
	
	

}
