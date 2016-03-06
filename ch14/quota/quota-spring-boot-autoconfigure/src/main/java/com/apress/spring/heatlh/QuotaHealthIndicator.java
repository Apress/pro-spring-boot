package com.apress.spring.heatlh;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class QuotaHealthIndicator implements HealthIndicator{

	
	@Override
	public Health health() {
		return Health.up().withDetail("jejeje.jajajaja", "hola").build();
	}

}
