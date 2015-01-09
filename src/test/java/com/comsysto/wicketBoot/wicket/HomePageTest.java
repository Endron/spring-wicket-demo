package com.comsysto.wicketBoot.wicket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class HomePageTest extends WicketTestBase {

	@Test
	public void renderPage() {
		tester.startPage(HomePage.class);
		tester.assertRenderedPage(HomePage.class);
	}
}
