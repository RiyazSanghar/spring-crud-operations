package com.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.entity.Course;
import com.jpa.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	

	
	public List<Course> getAllCourses(Long id)
	{
		List<Course> topics =new ArrayList<>();
		
		courseRepository.findByTopicId(id).forEach(topics::add);
		return topics;
	}
	
	public Course getCourse(Long id)
	{
		return courseRepository.findOne(id);
		
	}

	public Course addCourse(Course course) {
		return courseRepository.save(course);
		
	}

	public Course updateCourse(Course course) {
		
		
		return courseRepository.save(course);
		
	}

	public void deleteCourse(Long id) {
		
		courseRepository.delete(id);
		
	}
}
