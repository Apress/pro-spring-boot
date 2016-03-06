package com.apress.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.apress.spring.config.JournalProperties;

@SpringBootApplication
@RestController
public class SpringBootCalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCalendarApplication.class, args);
	}
	
	private static final String VIEW_INDEX = "index";
	
	@Autowired
	JournalProperties journal;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView modelAndView){
		modelAndView.setViewName(VIEW_INDEX);
		modelAndView.addObject("journal", journal);
		return modelAndView;
	}
}
