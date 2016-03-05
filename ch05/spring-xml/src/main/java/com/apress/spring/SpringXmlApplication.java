package com.apress.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apress.spring.service.SimpleService;

@RestController
@ImportResource({"META-INF/spring/services-context.xml"})
@SpringBootApplication
public class SpringXmlApplication {

	@Autowired
	SimpleService html;

	@RequestMapping("/")
	public String index(){
		return html.getHtmlH1From("Using Spring XML beans in here!");
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringXmlApplication.class, args);
	}
}
