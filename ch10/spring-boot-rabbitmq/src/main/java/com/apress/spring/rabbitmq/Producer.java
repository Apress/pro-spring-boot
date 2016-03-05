package com.apress.spring.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
	private static final Logger log = LoggerFactory.getLogger(Producer.class);
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	public void sendTo(String routingkey,String message){
		log.info("Sending> ...");
		this.rabbitTemplate.convertAndSend(routingkey,message);
	}
}
