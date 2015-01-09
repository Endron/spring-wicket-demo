package com.comsysto.wicketBoot.wicket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookPageTest extends WicketTestBase {

	@Test
	public void renderPage() {
		tester.startPage(BookPage.class);
		tester.assertRenderedPage(BookPage.class);
	}
}
