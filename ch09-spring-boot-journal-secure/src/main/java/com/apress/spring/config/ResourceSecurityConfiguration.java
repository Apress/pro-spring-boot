package com.apress.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ResourceSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		   .antMatchers("/").permitAll()
		   .antMatchers("/api/**").authenticated()
		   
		   // Version 1
		   //.and()
		   //.httpBasic();
		   
		   // Version 2
		   //.and()
		   //.formLogin();
		   
		   // Version 3
		   .and()
		   .formLogin().loginPage("/login").permitAll()
		   .and()
		   .logout().permitAll();
		   	
	}

}
