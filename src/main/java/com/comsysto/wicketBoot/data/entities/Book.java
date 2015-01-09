package com.comsysto.wicketBoot.data.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Represents an Book.
 */
@Entity
public class Book implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private String isbn;

	private String title;

	private String author;

	public Book() {
		super();
	}

	public Book(final String title, final String author, final String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	public Long getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(final String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(final String author) {
		this.author = author;
	}
}
