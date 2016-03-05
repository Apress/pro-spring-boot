package com.apress.spring;

import java.util.Date;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.apress.spring.rabbitmq.Producer;

@EnableScheduling
@SpringBootApplication
public class SpringBootRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRabbitmqApplication.class, args);
	}

	@Value("${myqueue}")
	String queue;
	
	@Bean
	Queue queue(){
		return new Queue(queue,false);
	}
	
	@Autowired
	Producer producer;
	
	@Scheduled(fixedDelay = 500L)
	public void sendMessages(){
		producer.sendTo(queue, "Hello World at " + new Date());
	}
	
	//@Bean
	//CommandLineRunner sender(Producer producer){
	//	return args -> {
	//		producer.sendTo(queue, "Hello World");
	//	};
	//}
}
