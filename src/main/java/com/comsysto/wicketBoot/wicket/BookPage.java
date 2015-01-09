package com.comsysto.wicketBoot.wicket;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;

import com.comsysto.wicketBoot.data.repository.BookRepository;

/**
 * Implements a page, that lists all books in the database.
 */
public class BookPage extends WebPage {

	@Inject
	BookRepository repository;

	public BookPage() {
		final List<BookModel> books = new LinkedList<>();
		repository.findAll().forEach(it -> books.add(new BookModel(it)));

		final ListDataProvider<BookModel> dataProvider = new ListDataProvider<>(books);

		final DataView<BookModel> dataView = new DataView<BookModel>("dataView", dataProvider) {
			@Override
			protected void populateItem(final Item<BookModel> item) {
				final RepeatingView redirectView = new RepeatingView("bookRows");
				redirectView.add(new Label(redirectView.newChildId(), item.getModelObject().getObject().getTitle()));
				redirectView.add(new Label(redirectView.newChildId(), item.getModelObject().getObject().getAuthor()));
				redirectView.add(new Label(redirectView.newChildId(), item.getModelObject().getObject().getIsbn()));
				item.add(redirectView);
			}
		};
		add(dataView);
	}
}
