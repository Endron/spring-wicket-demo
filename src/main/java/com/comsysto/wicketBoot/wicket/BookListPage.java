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
import org.apache.wicket.model.Model;

import com.comsysto.wicketBoot.data.entities.Book;
import com.comsysto.wicketBoot.data.repository.BookRepository;

/**
 * Implements a page, that lists all books in the database.
 */
public class BookListPage extends WebPage {

	@Inject
	BookRepository repository;

	public BookListPage() {
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

	private class BookModel extends Model<Book> {

		private final long bookId;
		private Book book;

		public BookModel(final Book book) {
			this.bookId = book.getId();
			this.book = book;
		}

		@Override
		public void detach() {
			book = null;

			super.detach();
		}

		@Override
		public Book getObject() {
			if (book == null) {
				book = repository.findOne(bookId);
			}

			return book;
		}

		@Override
		public void setObject(final Book object) {
			throw new RuntimeException("This model is read only.");
		}
	}
}
