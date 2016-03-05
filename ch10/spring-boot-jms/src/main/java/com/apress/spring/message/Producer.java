package com.apress.spring.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

public class Producer {
	private static final Logger log = LoggerFactory.getLogger(Producer.class);
	private JmsTemplate jmsTemplate;
	
	public Producer(JmsTemplate jmsTemplate){
		this.jmsTemplate = jmsTemplate;
	}
	
	public void sendTo(String queue, String message) {
		this.jmsTemplate.convertAndSend(queue, message);
		log.info("Producer> Message Sent");
	}
}
