package com.apress.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
public class SpringBootJmsV2Application {
	private static final Logger log = LoggerFactory.getLogger(SpringBootJmsV2Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJmsV2Application.class, args);
	}
	
	//@JmsListener(destination="${myqueue}")
	//public String simplerConsumer(String message){
	//	log.info("Simpler Consumer> " + message);
	//	return message + " and Spring Messaging too!";
	//}
	
	@JmsListener(destination="${myqueue}")
	@SendTo("${myotherqueue}")
	public String simplerConsumer(String message){
		log.info("Simpler Consumer> " + message);
		return message + " and Spring Messaging too!";
	}
	
	@JmsListener(destination="${myotherqueue}")
	public void anotherSimplerConsumer(String message){
		log.info("Another Simpler Consumer> " + message);
	}
	
	@Value("${myqueue}")
	String queue;
	
	@Bean
	CommandLineRunner start(JmsTemplate template){
		return args -> {
			log.info("Sending> ...");
			template.convertAndSend(queue, "SpringBoot Rocks!");
		};
	}
}
