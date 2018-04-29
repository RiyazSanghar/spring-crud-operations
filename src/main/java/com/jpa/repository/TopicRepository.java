package com.jpa.repository;

import com.jpa.entity.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Long> {

}
