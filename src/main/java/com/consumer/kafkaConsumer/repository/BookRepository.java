package com.consumer.kafkaConsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.consumer.kafkaConsumer.entity.Book;
import com.consumer.kafkaConsumer.entity.LibraryEvent;

@Component
public interface BookRepository extends  JpaRepository<Book, Integer>{

	
}
