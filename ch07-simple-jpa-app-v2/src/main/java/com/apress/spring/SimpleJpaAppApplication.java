package com.apress.spring;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.apress.spring.repository.JournalRepository;

@SpringBootApplication
public class SimpleJpaAppApplication {
	private static final Logger log = LoggerFactory.getLogger(SimpleJpaAppApplication.class);
	
	@Autowired
	JournalRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SimpleJpaAppApplication.class, args);
	}
	
	@Bean
	CommandLineRunner findAll(JournalRepository repo){
		return args -> {
			log.info("> findAll() ...");
			repo.findAll().forEach(entry -> log.info(entry.toString()));
		};
	}
	
    @Bean
	CommandLineRunner getOne(JournalRepository repo){
		return args -> {
			log.info("> getOne() ...");
			log.info(repo.getOne((long) 1).toString());
		};
	}
    
    @Bean
	CommandLineRunner findByCreatedAfter(JournalRepository repo){
		return args -> {
			log.info("> findByCreatedAfter() ...");
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			Date date = formatter.parse("02/01/2016");
			repo.findByCreatedAfter(date).forEach(entry -> log.info(entry.toString()));
		};
	}
    
    @Bean
	CommandLineRunner findByCustomQuery(JournalRepository repo){
		return args -> {
			log.info("> findByCustomQuery() ...");
			repo.findByCustomQuery("Cloud").forEach(entry -> log.info(entry.toString()));
		};
	}
}
