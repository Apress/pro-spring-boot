package com.apress.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalAuthentication
public class ResourceSecurityConfiguration extends WebSecurityConfigurerAdapter{
	private static final Logger log = LoggerFactory.getLogger(ResourceSecurityConfiguration.class);
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("@@@@@@ HERE- HTTP");
		http.authorizeRequests()
		   .antMatchers("/").permitAll()
		   .antMatchers("/api/**").authenticated()
		   .and()
		   .formLogin().loginPage("/login").permitAll()
		   .and()
		   .logout().permitAll();
		   //.and()
		   //.httpBasic();
				
	}

}
