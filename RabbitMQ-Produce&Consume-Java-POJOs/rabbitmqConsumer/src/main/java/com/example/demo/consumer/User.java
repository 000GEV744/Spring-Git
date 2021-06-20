package com.example.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.demo.dto.OrderStatus;
import com.example.demo.util.QueueConstants;

@Component
public class User {

	@RabbitListener(queues = {QueueConstants.MY_Queue})
	public void consumeMessageFromQueues(OrderStatus orserStatus) {
		System.out.println("Message: [ "+orserStatus+" ]");
	}
}
