package com.example.demo.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.util.QueueConstants;

@Configuration
public class MessagingConfig {

	@Bean
	public Queue getMyQueue() {
		return new Queue(QueueConstants.MY_Queue);
	}
	
	@Bean
	public TopicExchange getTopicExchange() {
		return ExchangeBuilder
				.topicExchange(QueueConstants.EXCHANGE)
				.durable(true)
				.build();
	}
	
	@Bean
	public Binding getBinding() {
		return BindingBuilder.bind(getMyQueue())
				.to(getTopicExchange())
				.with(QueueConstants.ROUTING_KEY);
	}
	
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
		cachingConnectionFactory.setUsername("guest");
		cachingConnectionFactory.setPassword("guest");
		return cachingConnectionFactory;
	}
	
	@Bean
	public AmqpTemplate tempate() {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;
	}
	
}
