package com.consumer.kafkaConsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.consumer.kafkaConsumer.service.LibraryEventService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component

public class LibraryEventConsumer {

	@Autowired
	LibraryEventService libraryService;
	
	Logger logger=LoggerFactory.getLogger(getClass());
	
	@KafkaListener(topics= {"library-events"})
	public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
	    libraryService.processLibraryEvents(consumerRecord);
		logger.info("Consumer Record::"+consumerRecord.toString());
	}
	
	
}
