package com.comsysto.wicketBoot.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.springframework.data.domain.Sort;

import com.comsysto.wicketBoot.wicket.bookTablePanel.BookProvider;
import com.comsysto.wicketBoot.wicket.bookTablePanel.BookTablePanel;

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
