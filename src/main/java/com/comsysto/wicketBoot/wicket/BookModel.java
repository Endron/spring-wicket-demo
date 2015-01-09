package com.comsysto.wicketBoot.wicket;

import javax.inject.Inject;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.springframework.data.repository.CrudRepository;

import com.comsysto.wicketBoot.data.entities.Book;

/**
 * Model-Class for Books.
 */
public class BookModel extends LoadableDetachableModel<Book> {

	@Inject
	CrudRepository<Book, Long> repository;
	
	private final long bookId;

	public BookModel(final Book book) {
		super(book);
		this.bookId = book.getId();
		
		Injector.get().inject(this);
	}

	@Override
	protected Book load() {
		return repository.findOne(bookId);
	}

	@Override
	public void setObject(final Book object) {
		throw new RuntimeException("This model is read only.");
	}
}
