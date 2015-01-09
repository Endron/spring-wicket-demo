package com.comsysto.wicketBoot.webapp.pages;

import org.apache.wicket.markup.html.WebPage;
import org.springframework.data.domain.Sort;

import com.comsysto.wicketBoot.webapp.bookTablePanel.BookProvider;
import com.comsysto.wicketBoot.webapp.bookTablePanel.BookTablePanel;

/**
 * Implements a page, that lists all books in the database.
 */
public class BookPage extends WebPage {

	public BookPage() {
		add(new BookTablePanel("orderedById", new BookProvider()));
		add(new BookTablePanel("orderedByTitle", new BookProvider(new Sort("title"))));
		add(new BookTablePanel("orderedByAuthor", new BookProvider(new Sort("author"))));
	}
}
