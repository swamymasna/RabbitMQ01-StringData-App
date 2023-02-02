package com.swamy.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.swamy.config.RabbitMQConfig;

@Service
public class RabbitMQProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);
	
	@Value("${rabbitmq.queue.name}")
	private String queue;
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;

	@Value("${rabbitmq.routingkey.name}")
	private String routingKey;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public String sendMessage(String message) {
		
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
		LOGGER.info(String.format("Message Sent Successfully : %s", message));
		return "Message Sent Successfully";
	}
}







