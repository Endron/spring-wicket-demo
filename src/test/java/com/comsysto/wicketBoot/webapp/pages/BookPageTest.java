package com.comsysto.wicketBoot.webapp.pages;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comsysto.wicketBoot.webapp.WicketTestBase;
import com.comsysto.wicketBoot.webapp.pages.BookPage;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookPageTest extends WicketTestBase {

	@Test
	public void renderPage() {
		tester.startPage(BookPage.class);
		tester.assertRenderedPage(BookPage.class);
	}
}
