package com.apress.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSimpleApplication {

	public static void main(String[] args) {
		//Comment and uncomment the versions for testing.
		//Version 1.
		//SpringApplication.run(SpringBootSimpleApplication.class, args);
		
		//Version 2.
		SpringApplication app = new SpringApplication(SpringBootSimpleApplication.class);
		//add more features here
		app.run(args);
		
		//Version 3.
		//SpringApplication app = new SpringApplication(SpringBootSimpleApplication.class);
		//app.setBanner(new Banner() {
		//	@Override
		//	public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
		//		out.print("\n\n\tThis is my own banner!\n\n".toUpperCase());			
		//	}
		//});
	    //app.run(args);
	}
}
