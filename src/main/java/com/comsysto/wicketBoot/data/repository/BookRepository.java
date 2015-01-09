package com.comsysto.wicketBoot.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.comsysto.wicketBoot.data.entities.Book;

/**
 * Repository to access {@link Book} entities.
 */
@Transactional(readOnly = true)
public interface BookRepository extends CrudRepository<Book, Long> {

	/**
	 * Get all {@link Book}s with the given {@code title}.
	 * 
	 * @param title
	 *            the name of the books
	 * 
	 * @return a {@link List} of {@link Book}s
	 */
	List<Book> findByTitle(final String title);

	/**
	 * Get all {@link Book}s by the given {@code author}
	 * 
	 * @param author
	 *            the author of the books
	 * 
	 * @return a {@link List} of {@link Book}s
	 */
	List<Book> findByAuthor(final String author);

	/**
	 * Get all {@link Book}s with the given {@code isbn}.
	 * 
	 * @param isbn
	 *            the isbn
	 * 
	 * @return a {@link List} of {@link Book}s
	 */
	List<Book> findByIsbn(final String isbn);
}
