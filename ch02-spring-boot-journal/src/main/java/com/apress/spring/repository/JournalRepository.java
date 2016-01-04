package com.apress.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apress.spring.domain.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long> {
	
}
