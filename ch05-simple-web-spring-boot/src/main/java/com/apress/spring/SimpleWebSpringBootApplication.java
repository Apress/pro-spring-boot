package com.apress.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class SimpleWebSpringBootApplication {

	@RequestMapping("/showMessage.html")
	public String index(){
		return "Spring Boot Rocks!";
	}

	public static void main(String[] args) {
		SpringApplication.run(SimpleWebSpringBootApplication.class, args);
	}
}
