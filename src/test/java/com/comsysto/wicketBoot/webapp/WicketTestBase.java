package com.comsysto.wicketBoot.webapp;

import javax.inject.Inject;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comsysto.wicketBoot.ApplicationStarter;
import com.comsysto.wicketBoot.webapp.MyWebApplication;

/**
 * Base class for Tests of Wicket components. Creates the {@link WicketTester}.
 * For tests to work correctly they must be executed by
 * {@link SpringJUnit4ClassRunner}.
 */
@SpringApplicationConfiguration(classes = ApplicationStarter.class)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public abstract class WicketTestBase {

	@Inject
	MyWebApplication webApp;

	protected WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(webApp);
	}
}
