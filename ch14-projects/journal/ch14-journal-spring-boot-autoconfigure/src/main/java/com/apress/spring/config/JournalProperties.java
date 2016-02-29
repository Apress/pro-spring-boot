package com.apress.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="journal")
public class JournalProperties {

	private String contextPath;
	private Boolean enableRestApi;
	
	public String getContextPath() {
		return contextPath;
	}
	
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	
	public Boolean getEnableRestApi() {
		return enableRestApi;
	}
	
	public void setEnableRestApi(Boolean enableRestApi) {
		this.enableRestApi = enableRestApi;
	}

}
