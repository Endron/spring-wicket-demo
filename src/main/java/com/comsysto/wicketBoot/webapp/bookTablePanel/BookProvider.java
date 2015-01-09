package com.comsysto.wicketBoot.webapp.bookTablePanel;

import java.util.Iterator;

import javax.inject.Inject;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.comsysto.wicketBoot.data.entities.Book;
import com.comsysto.wicketBoot.webapp.BookModel;

/**
 * {@link IDataProvider} to read all the {@link Book}s from the database. By
 * default the Books are ordered by there IDs. Custom ordering can be obtained
 * if required by using the correct constructor.
 */
public class BookProvider implements IDataProvider<Book> {

	private final Sort sort;

	@Inject
	PagingAndSortingRepository<Book, Long> repository;

	public BookProvider() {
		this(new Sort("id"));
	}

	public BookProvider(final Sort sort) {
		this.sort = sort;

		Injector.get().inject(this);
	}

	@Override
	public void detach() {
		/*
		 * no state to be detached.
		 */
	}

	@Override
	public long size() {
		return repository.count();
	}

	@Override
	public Iterator<? extends Book> iterator(long first, long count) {
		/*
		 * Some calculations are needed to adapt to Spring Datas page-based way.
		 */
		final int currentPage = Long.valueOf(first / count).intValue();
		final Pageable pageable = new PageRequest(currentPage, (int) count, sort);

		return repository.findAll(pageable).iterator();
	}

	@Override
	public IModel<Book> model(final Book object) {
		return new BookModel(object);
	}
}
