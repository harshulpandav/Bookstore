package com.egen.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egen.bookstore.model.Book;

/**
 * DAO implementation for Book entity
 *  
 */
@Repository
public class BookDaoImpl implements BookDao {
	 
    @PersistenceContext
    private EntityManager em;
    
	@Transactional
	@Override
	public Book addBook(Book book) {
		em.persist(book);
		return book;
	}
	
	@Transactional
	@Override
	public Book updateBook(Book book) {
		em.merge(book);
		return book;
	}

	@Override
	public List<Book> findBookByName(String name) {
		TypedQuery<Book> query = em.createQuery("select b from Book b where b.name = ?1", Book.class);
	    query.setParameter(1, name);
	    return query.getResultList();
	}

	@Override
	public List<Book> getAllBooks() {
		 return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
	}

	@Override
	public Book findBookById(Long id) {
		Book book = em.find(Book.class, id);
		return book;
	}

	
}
