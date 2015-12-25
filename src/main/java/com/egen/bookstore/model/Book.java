package com.egen.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
 
/**
 * Book entity
 */
@Entity
public class Book {
 
    @Id
    @Column(name="Id")
	@GeneratedValue
    private Long id;
    
    private String name;
    private String authors;
    
    @ManyToOne
    private User checkedOutBy;
    
    public Book() {}

    

	public Book(String name, String authors, User checkedOutBy) {
		super();
		this.name = name;
		this.authors = authors;
		this.checkedOutBy = checkedOutBy;
	}



	public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAuthors() {
		return authors;
	}



	public void setAuthors(String authors) {
		this.authors = authors;
	}



	public User getCheckedOutBy() {
		return checkedOutBy;
	}



	public void setCheckedOutBy(User checkedOutBy) {
		this.checkedOutBy = checkedOutBy;
	}



	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", authors=" + authors + ", checkedOutBy=" + checkedOutBy + "]";
	}

}
