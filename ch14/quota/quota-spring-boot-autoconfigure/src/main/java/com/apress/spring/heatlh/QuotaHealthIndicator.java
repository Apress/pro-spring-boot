package com.apress.spring.heatlh;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class QuotaHealthIndicator implements HealthIndicator{

	
	@Override
	public Health health() {
		return Health.up().withDetail("quota.size", getSize()).build();
	}

	protected String getSize(){
		//Step. Process to get the Size
		return "12304 bytes";
	}
}
