package com.egen.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.egen.bookstore.model.Book;

@Service
public interface BookService {

	public Book addBook(Book book);
	
	public List<Book> findBookByName(String name);
	
	public List<Book> getAllBooks();

	
	public Object checkOutBook(Long userId, Long bookId);
}
