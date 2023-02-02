package com.swamy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swamy.producer.RabbitMQProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageRestController {

	@Autowired
	private RabbitMQProducer rabbitMQProducer;

	@GetMapping("/send")
	public ResponseEntity<String> publishMessage(@RequestParam(value = "message") String message) {
		String sentMessage = rabbitMQProducer.sendMessage(message);
		return ResponseEntity.ok(sentMessage);
	}
}