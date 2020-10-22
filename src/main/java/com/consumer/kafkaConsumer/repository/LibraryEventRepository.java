package com.consumer.kafkaConsumer.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.consumer.kafkaConsumer.entity.LibraryEvent;

@Repository
@Component
public interface LibraryEventRepository extends  JpaRepository<LibraryEvent, Long> {

}
