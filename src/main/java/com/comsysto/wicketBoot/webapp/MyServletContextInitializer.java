package com.comsysto.wicketBoot.webapp;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.wicket.protocol.http.WicketFilter;
import org.apache.wicket.spring.SpringWebApplicationFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

/**
 * Configure the Servlet Context to include the Wicket Web Application.
 */
@Configuration
public class MyServletContextInitializer implements ServletContextInitializer {

	private final Logger logger = LoggerFactory.getLogger(MyServletContextInitializer.class);

	@Override
	public void onStartup(final ServletContext sc) throws ServletException {
		logger.debug("executing MyWebAppInitializer");

		final FilterRegistration filter = sc.addFilter("wicket-filter", WicketFilter.class);
		filter.setInitParameter(WicketFilter.APP_FACT_PARAM, SpringWebApplicationFactory.class.getName());
		filter.setInitParameter("applicationBean", MyWebApplication.BEAN_NAME);

		// This line is the only surprise when comparing to the equivalent
		// web.xml. Without some initialization seems to be missing.
		filter.setInitParameter(WicketFilter.FILTER_MAPPING_PARAM, "/*");
		filter.addMappingForUrlPatterns(null, false, "/*");
	}
}
