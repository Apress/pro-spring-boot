package com.apress.spring.heatlh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.apress.spring.repository.JournalRepository;

@Component
public class QuotaHealthIndicator implements HealthIndicator{
	
	private static final Long QUOTA_MAX_SIZE = 10L;
	
	@Autowired
	JournalRepository repo;
	
	@Override
	public Health health() {
		long size = repo.count();
		if(size <= QUOTA_MAX_SIZE)
			return Health.up().withDetail("quota.entries", size).build();
		else
			return Health.down().withDetail("quota.entries", size).withException(new QuotaException("Quota Exceeded. Max allow: " + QUOTA_MAX_SIZE + ". See your Administrator for Quota policies.")).build();
	}	
	
	
}
