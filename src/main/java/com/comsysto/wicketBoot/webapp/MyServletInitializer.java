package com.comsysto.wicketBoot.webapp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import com.comsysto.wicketBoot.ApplicationStarter;

/**
 * {@link SpringBootServletInitializer} for when the application is deployed on
 * a standalone web server instead of an embaded web server.
 */
public class MyServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(ApplicationStarter.class);
	}
}
