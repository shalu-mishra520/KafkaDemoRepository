package com.consumer.kafkaConsumer.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class LibraryEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long libraryEventId;
	
	@Enumerated(EnumType.STRING)
	private LibraryEventType eventType;
	
	@OneToOne(mappedBy = "libraryEvent")
	private Book book;

	public LibraryEvent(Long libraryEventId, Book book) {
		super();
		this.libraryEventId = libraryEventId;
		this.book = book;
	}

	public LibraryEvent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getLibraryEventId() {
		return libraryEventId;
	}

	public void setLibraryEventId(Long libraryEventId) {
		this.libraryEventId = libraryEventId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "LibraryEvent [libraryEventId=" + libraryEventId + ", eventType=" + eventType +"]";
	}

	public LibraryEventType getEventType() {
		return eventType;
	}

	public void setEventType(LibraryEventType eventType) {
		this.eventType = eventType;
	}
	
	
}
