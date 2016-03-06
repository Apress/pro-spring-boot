package com.apress.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JournalSpringBootAutoconfigureApplication.class)
@WebAppConfiguration
public class JournalSpringBootAutoconfigureApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(JournalSpringBootAutoconfigureApplicationTests.class);
	
	@Test
	public void contextLoads() {
		log.info("TESTING!");
	}

}
