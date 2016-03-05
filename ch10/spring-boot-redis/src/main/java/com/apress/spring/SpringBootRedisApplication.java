package com.apress.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.apress.spring.redis.Producer;

@SpringBootApplication
public class SpringBootRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisApplication.class, args);
	}
	
	@Value("${topic}")
	String topic;
	
	@Bean
	CommandLineRunner sendMessage(Producer producer){
		return args -> {
			producer.sendTo(topic, "Spring Boot rocks with Redis messaging!");
		};
	}
}
