package com.apress.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;

import com.apress.spring.message.Producer;

@SpringBootApplication
public class SpringBootJmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJmsApplication.class, args);
	}
	
	@Value("${myqueue}")
	String queue;
	
	@Bean
	CommandLineRunner sendMessage(JmsTemplate jmsTemplate){
		return args -> {
			Producer producer = new Producer(jmsTemplate);
			producer.sendTo(queue, "Spring Boot Rocks!");
		};
	}
}
