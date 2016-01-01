package com.apress.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleWebController {

        @RequestMapping("/")
        public String greetings(){
            return "<h1> Spring Boot Rocks in Java too!</h1>";
        }   
}

