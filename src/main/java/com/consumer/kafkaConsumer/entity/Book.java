package com.consumer.kafkaConsumer.entity;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Book {
	
	@Id
    private Integer bookId;
	private String bookName;
	private String bookAuthor;
	
	
	@OneToOne
    @JoinColumn(name = "libraryEventId")
    private LibraryEvent libraryEvent;
	
	public LibraryEvent getLibraryEvent() {
		return libraryEvent;
	}


	public void setLibraryEvent(LibraryEvent libraryEvent) {
		this.libraryEvent = libraryEvent;
	}


	public Book() {
		}
	
	
	public Book(Integer bookId, String bookName, String bookAuthor) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}
	
	
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", libraryEvent="
				+ libraryEvent + "]";
	}


	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

}
