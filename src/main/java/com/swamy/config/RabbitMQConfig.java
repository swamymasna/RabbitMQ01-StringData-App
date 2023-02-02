package com.swamy.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

	@Value("${rabbitmq.queue.name}")
	private String queue;
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;

	@Value("${rabbitmq.routingkey.name}")
	private String routingkey;
	
	// Create the Queue
	@Bean
	public Queue queue() {
		return new Queue(queue);
	}	
	
	// Create the Exchange
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange);
	}
	
	// Bind Queue to Exchange with Routing Key
	@Bean
	public Binding binding() {
		return BindingBuilder
				.bind(queue())
				.to(exchange())
				.with(routingkey);
	}
	
}
