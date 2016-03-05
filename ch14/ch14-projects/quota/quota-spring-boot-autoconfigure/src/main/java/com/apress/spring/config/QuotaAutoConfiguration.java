package com.apress.spring.config;

import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.apress.spring.heatlh.QuotaHealthIndicator;

@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(QuotaProperties.class)
@ConditionalOnProperty(prefix = "quota", name = { "enable"}, matchIfMissing = false)
public class QuotaAutoConfiguration {
	
	@Bean
	HealthIndicator quotaHealthIndicator(){
		return new QuotaHealthIndicator(); 
	}
}
