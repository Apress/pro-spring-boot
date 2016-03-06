package com.apress.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.transaction.annotation.Transactional;

import com.apress.spring.domain.JournalEntry;

@Transactional
@RepositoryRestResource(collectionResourceRel = "entry", path = "journal")
public interface JournalRepository extends JpaRepository<JournalEntry, Long> { 

	List<JournalEntry> findByCreatedAfter(@Param("after") @DateTimeFormat(iso = ISO.DATE) Date date);
	List<JournalEntry> findByCreatedBetween(@Param("after") @DateTimeFormat(iso = ISO.DATE) Date after,@Param("before") @DateTimeFormat(iso = ISO.DATE) Date before);
	List<JournalEntry> findByTitleContaining(@Param("word") String word);
	List<JournalEntry> findBySummaryContaining(@Param("word") String word);
	
}
