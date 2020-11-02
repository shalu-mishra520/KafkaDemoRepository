package com.consumer.kafkaConsumer.service;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumer.kafkaConsumer.entity.Book;
import com.consumer.kafkaConsumer.entity.LibraryEvent;
import com.consumer.kafkaConsumer.repository.BookRepository;
import com.consumer.kafkaConsumer.repository.LibraryEventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LibraryEventService {
	
	Logger logger =LoggerFactory.getLogger(getClass());
	
	@Autowired
	ObjectMapper objMapper;
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	LibraryEventRepository repository;
	

	public void processLibraryEvents(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
	
		
     logger.info("inside processlibrary events");	
     
	 LibraryEvent	event=objMapper.readValue(consumerRecord.value(),LibraryEvent.class);
	 
	 logger.info("event logged:"+event.getEventType());
	 switch(event.getEventType()){
	 
	 case NEW:
		 logger.info("new eventtype");
		 save(event);
		 break;
		 
	 case UPDATE:
		 logger.info("update eventtype");
		 validate(event);
		   save(event);
		 break;
		 
	default:
		logger.info("Invalid library Event type");
		break;
	 
	 }
			 
	}

	private void validate(LibraryEvent event) {
		if(event.getLibraryEventId()==null) {
			logger.info("library event type cannot be null");
			throw new IllegalArgumentException();
		}
		logger.info(" fetching library event id "+event.getLibraryEventId());
		Optional<LibraryEvent> resultevent=repository.findById(event.getLibraryEventId());
		//Optional<Book> resultbook=bookRepository.findById(event.getBook().getBookId());
		
		if(!resultevent.isPresent()) {
			throw new IllegalArgumentException("Not a library event");
		}
		
		logger.info("validation is successfully done ");
		
	}

	private void save(LibraryEvent libraryEvent) {
	   
		
		libraryEvent.getBook().setLibraryEvent(libraryEvent);
		logger.info("event :"+libraryEvent.getBook());
			logger.info("after save");
			
			repository.save(libraryEvent);
			
			bookRepository.save(libraryEvent.getBook());
		
	}
   
}
