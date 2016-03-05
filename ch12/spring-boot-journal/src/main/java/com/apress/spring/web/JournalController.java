package com.apress.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.apress.spring.repository.JournalRepository;

@RestController
public class JournalController {
	
	private static final String VIEW_INDEX = "index";
	@Autowired
	JournalRepository repo;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView modelAndView){
		modelAndView.setViewName(VIEW_INDEX);
		modelAndView.addObject("journal", repo.findAll());
		return modelAndView;
	}
}
