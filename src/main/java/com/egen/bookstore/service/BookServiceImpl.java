package com.egen.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.bookstore.dao.BookDao;
import com.egen.bookstore.dao.UserDao;
import com.egen.bookstore.model.Book;
import com.egen.bookstore.model.User;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public Book addBook(Book book) {
		if(book.getName()!=null)
		bookDao.addBook(book);
		return book;
	}

	@Override
	public List<Book> findBookByName(String name) {
		return bookDao.findBookByName(name);
	}

	@Override
	public Object checkOutBook(Long userId, Long bookId) {
		Book book = bookDao.findBookById(bookId);
		User user = userDao.getUser(userId);
		if(user==null) return "User does not exist"; 
		String response="Book not available in inventory";
		if(book!=null){
			if(book.getCheckedOutBy()==null){
				book.setCheckedOutBy(user);
				bookDao.updateBook(book);
				return book;
			}
			else{
				return "Book already checked out";
			}
		}
		return response;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

}
