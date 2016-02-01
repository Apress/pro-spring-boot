package com.apress.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.apress.spring.domain.Journal;

@Service
public class JournalService {
	private static final Logger log = LoggerFactory.getLogger(JournalService.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insertData(){
		log.info("> Table creation");
		jdbcTemplate.execute("DROP TABLE JOURNAL IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE JOURNAL(id SERIAL, title VARCHAR(255), summary VARCHAR(255), created TIMESTAMP)");
		log.info("> Inserting data...");
		jdbcTemplate.execute("INSERT INTO JOURNAL(title,summary,created) VALUES('Get to know Spring Boot','Today I will learn Spring Boot','2016-01-01 00:00:00.00')");
		jdbcTemplate.execute("INSERT INTO JOURNAL(title,summary,created) VALUES('Simple Spring Boot Project','I will do my first Spring Boot project','2016-01-02 00:00:00.00')");
		jdbcTemplate.execute("INSERT INTO JOURNAL(title,summary,created) VALUES('Spring Boot Reading','Read more about Spring Boot','2016-02-01 00:00:00.00')");
		jdbcTemplate.execute("INSERT INTO JOURNAL(title,summary,created) VALUES('Spring Boot in the Cloud','Learn Spring Boot using Cloud Foundry','2016-01-01 00:00:00.00')");
		log.info("> Done.");
	}
	
	public List<Journal> findAll(){
		List<Journal> entries = new ArrayList<>();
		jdbcTemplate.query("SELECT * FROM JOURNAL", 
					new Object[]{}, 
					(rs,row) -> new Journal(rs.getLong("id"), rs.getString("title"), rs.getString("summary"),new Date(rs.getTimestamp("created").getTime())))
				.forEach(entry -> entries.add(entry));
		return entries;
	}
}