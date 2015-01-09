package com.comsysto.wicketBoot.wicket;

import javax.inject.Inject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;

import com.comsysto.wicketBoot.data.entities.Book;
import com.comsysto.wicketBoot.data.repository.BookRepository;

/**
 * Implements a page, that lists all books in the database.
 */
public class BookPage extends WebPage {

	@Inject
	BookRepository repository;

	public BookPage() {
		final IDataProvider<Book> dataProvider = new BookProvider();

		final DataView<Book> dataView = new DataView<Book>("dataView", dataProvider) {
			@Override
			protected void populateItem(final Item<Book> item) {
				final RepeatingView redirectView = new RepeatingView("bookRows");
				redirectView.add(new Label(redirectView.newChildId(), item.getModelObject().getTitle()));
				redirectView.add(new Label(redirectView.newChildId(), item.getModelObject().getAuthor()));
				redirectView.add(new Label(redirectView.newChildId(), item.getModelObject().getIsbn()));
				item.add(redirectView);
			}
		};
		dataView.setItemsPerPage(3);
		
		add(dataView);
		add(new PagingNavigator("pagingNavigator", dataView));
	}
}
