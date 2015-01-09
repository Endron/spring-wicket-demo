package com.comsysto.wicketBoot.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component(value = MyWebApplication.BEAN_NAME)
public class MyWebApplication extends WebApplication {

	/**
	 * Name of the Spring-Bean created from this class. Used to reference the
	 * bean by name.
	 */
	public final static String BEAN_NAME = "myWebApplication";

	private final Logger logger = LoggerFactory
			.getLogger(MyWebApplication.class);

	@Autowired
	ApplicationContext ctx;

	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

	@Override
	protected void init() {
		super.init();

		logger.info("init MyWebApplication");

		getComponentInstantiationListeners().add(
				new SpringComponentInjector(this, ctx));

		// mountPage("/home", HomePage.class);
	}
}
