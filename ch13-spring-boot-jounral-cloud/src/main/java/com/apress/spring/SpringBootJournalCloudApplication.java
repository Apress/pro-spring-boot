package com.apress.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringBootJournalCloudApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJournalCloudApplication.class, args);
	}
}
