package com.apress.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;

@SpringBootApplication(exclude={JpaRepositoriesAutoConfiguration.class,RepositoryRestMvcAutoConfiguration.class})
public class JournalSpringBootAutoconfigureApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalSpringBootAutoconfigureApplication.class, args);
	}
}
