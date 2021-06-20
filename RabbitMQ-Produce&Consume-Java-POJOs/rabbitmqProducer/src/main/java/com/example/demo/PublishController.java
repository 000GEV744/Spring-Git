package com.example.demo;

import java.util.UUID;

import javax.websocket.server.PathParam;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Order;
import com.example.demo.dto.OrderStatus;
import com.example.demo.util.QueueConstants;

@RestController
@RequestMapping("/api/order/v1")
public class PublishController {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@PostMapping("/{restaurantName}")
	public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
		order.setOrderId(UUID.randomUUID().toString());
		//restaurant-Service
		//payment-service
		OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "Order Placed Successfully in "+restaurantName);
		rabbitTemplate.convertAndSend(QueueConstants.EXCHANGE, QueueConstants.ROUTING_KEY, orderStatus);
		return "Success!";
	}
}
