package com.comsysto.wicketBoot.webapp;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.comsysto.wicketBoot.webapp.pages.BookPage;
import com.comsysto.wicketBoot.webapp.pages.HomePage;

@Component(value = MyWebApplication.BEAN_NAME)
public class MyWebApplication extends WebApplication {

	/**
	 * Name of the Spring-Bean created from this class. Used to reference the
	 * bean by name.
	 */
	public final static String BEAN_NAME = "myWebApplication";

	@Autowired
	ApplicationContext ctx;

	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

	@Override
	protected void init() {
		super.init();

		getComponentInstantiationListeners().add(new SpringComponentInjector(this, ctx));

		mountPage("/home", HomePage.class);
		mountPage("/books", BookPage.class);
	}
}
