package com.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jpa.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
	
	public List<Course> findByTopicId(Long topicId);

}
