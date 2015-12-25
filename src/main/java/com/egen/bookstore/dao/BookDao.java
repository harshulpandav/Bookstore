package com.egen.bookstore.dao;

import java.util.List;

import com.egen.bookstore.model.Book;

public interface BookDao {
	
	public Book addBook(Book book);
	
	public Book updateBook(Book book);
	
	public List<Book> getAllBooks();
	
	public List<Book> findBookByName(String name);
	
	public Book findBookById(Long id);
}
