package com.comsysto.wicketBoot.data;

import javax.inject.Inject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.comsysto.wicketBoot.data.entities.Book;
import com.comsysto.wicketBoot.data.repository.BookRepository;

/**
 * {@link CommandLineRunner} used to initial load a number of books into the
 * data base. Mainly to make sure there are some.
 * 
 * TODO should be removed at some point
 */
@Component
public class PopulateBookTableRunner implements CommandLineRunner {

	@Inject
	BookRepository repository;

	@Override
	@Transactional
	public void run(final String... args) throws Exception {
		/*
		 * Delete all books currently in the database.
		 */
		repository.delete(repository.findAll());

		/*
		 * Add some new books.
		 */
		repository.save(new Book("The Lord of the Rings", "J. R. R. Tolkien", "978-0007525546"));
		repository.save(new Book("Effective Java; A Proramming Language Guide", "Joshua Bloch", "978-0321356680"));
		repository.save(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "978-0345391803"));
	}
}
