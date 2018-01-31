package com.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.jpa.entity.Topics;

public interface TopicRepository extends CrudRepository<Topics, Long> {

}
