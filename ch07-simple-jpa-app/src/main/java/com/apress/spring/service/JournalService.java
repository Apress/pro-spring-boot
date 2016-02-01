package com.apress.spring.service;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apress.spring.domain.Journal;
import com.apress.spring.repository.JournalRepository;

@Service
public class JournalService {
	private static final Logger log = LoggerFactory.getLogger(JournalService.class);
	
	@Autowired
	JournalRepository repo;
	
	public void insertData() throws ParseException{
		log.info("> Inserting data...");
		repo.save(new Journal("Get to know Spring Boot","Today I will learn Spring Boot","01/01/2016"));
		repo.save(new Journal("Simple Spring Boot Project","I will do my first Spring Boot Project","01/02/2016"));
		repo.save(new Journal("Spring Boot Reading","Read more about Spring Boot","02/01/2016"));
		repo.save(new Journal("Spring Boot in the Cloud","Spring Boot using Cloud Foundry","03/01/2016"));
		log.info("> Done.");
	}
	
	public List<Journal> findAll(){
		return repo.findAll();
	}
	
}