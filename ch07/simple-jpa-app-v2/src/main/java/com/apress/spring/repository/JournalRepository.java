package com.apress.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apress.spring.domain.Journal;


public interface JournalRepository extends JpaRepository<Journal, Long> { 

	List<Journal> findByCreatedAfter(Date date);
	
	@Query("select j from Journal j where j.title like %?1%")
	List<Journal> findByCustomQuery(String word);
}
