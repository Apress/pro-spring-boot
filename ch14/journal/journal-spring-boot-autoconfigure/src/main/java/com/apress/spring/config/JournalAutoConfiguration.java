package com.apress.spring.config;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.util.ClassUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.AbstractController;

import com.apress.spring.repository.JournalRepository;

@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass(JournalRepository.class)
@EnableConfigurationProperties(JournalProperties.class)
@ConditionalOnProperty(prefix = "journal", name = { "context-path", "banner" }, matchIfMissing = true)
public class JournalAutoConfiguration extends RepositoryRestMvcConfiguration {
	private final String API_PATH = "/api";
	private final String BANNER = "/META-INF/banner/journal.txt";

	@Autowired
	JournalProperties journal;

	@Autowired
	Environment environment;

	@Bean
	InitializingBean simple() {
		return () -> {
			Banner banner = null;
			ResourceLoader resourceLoader = new DefaultResourceLoader(ClassUtils.getDefaultClassLoader());
			Resource resource = resourceLoader.getResource(BANNER);

			if (null == journal.getBanner()) {
				banner = new ResourceBanner(resource);
			} else {
				Resource _resource = resourceLoader.getResource(journal.getBanner());
				if (resource.exists()) {
					banner = new ResourceBanner(_resource);
				}
			}
			banner.printBanner(environment, environment.getClass(), System.out);
		};
	}

	@Override
	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		if (null == journal.getApiPath())
			config.setBasePath(API_PATH);
		else
			config.setBasePath(journal.getApiPath());
	}

	@Autowired
	JournalRepository repo;

	@Bean
	AbstractController journalController() {
		return new AbstractController() {
			@Override
			protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				ModelAndView model = new ModelAndView();
				model.setViewName("journal");
				model.addObject("journal", repo.findAll());
				return model;
			}
		};
	}

	@Bean
	public SimpleUrlHandlerMapping urlHandler() {
		SimpleUrlHandlerMapping handler = new SimpleUrlHandlerMapping();
		handler.setOrder(Integer.MAX_VALUE - 2);
		Properties mappings = new Properties();
		mappings.put(journal.getContextPath(), "journalController");
		handler.setMappings(mappings);
		return handler;
	}

}
