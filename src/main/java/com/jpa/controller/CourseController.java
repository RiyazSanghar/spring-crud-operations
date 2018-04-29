package com.jpa.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entity.Course;
import com.jpa.entity.Topic;
import com.jpa.service.CourseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Course Resource", produces = "It is Anands Practice")
public class CourseController {

	
	@Autowired
	@ApiModelProperty(notes = "These are some notes")
	private CourseService courseService;
	
	
	@ApiOperation(value = "Get Courses Based On Topic (Pass topic id)")
	@RequestMapping(value = "/topics/{id}/courses",method = RequestMethod.GET)
	@ApiResponses(
			value = {
					@ApiResponse(code = 500, message = "Internal Server Error"),
					@ApiResponse(code = 501, message = "Internal Server Error")
			}
			)
	public List<Course> getAllCourses(@PathVariable Long id)
	{
		
		return courseService.getAllCourses(id);
	}
	
	@ApiOperation(value = "Get Particular Course Based On id")
	@RequestMapping(value ="/topics/{topicId}/courses/{courseId}", method = RequestMethod.GET)
	@ApiResponses(
			value = {
					@ApiResponse(code = 500, message = "Internal Server Error"),
					@ApiResponse(code = 501, message = "Internal Server Error")
			}
			)
	public Course getCourse(@PathVariable Long courseId)
	{
		return courseService.getCourse(courseId);
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST,value = "/topics/{topicId}/courses")
	@ApiResponses(
			value = {
					@ApiResponse(code = 500, message = "Internal Server Error"),
					@ApiResponse(code = 501, message = "Internal Server Error")
			}
			)
	public ResponseEntity<Course> addCourse(@RequestBody Course course, @PathVariable Long topicId)
	{
		course.setTopic(new Topic(topicId,"",""));
		Course result = courseService.addCourse(course);

		return new ResponseEntity<Course>(result, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Update Course (associated topic id is needed)")
	@RequestMapping(method = RequestMethod.PUT,value = "/topics/{topicId}/courses/{id}")
	@ApiResponses(
			value = {
					@ApiResponse(code = 500, message = "Internal Server Error"),
					@ApiResponse(code = 501, message = "Internal Server Error")
			}
			)
	public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable Long topicId, @PathVariable String id)
	{
		course.setTopic(new Topic(topicId,"",""));
		Course result  =courseService.updateCourse(course);

		return new ResponseEntity<Course>(result, HttpStatus.OK);
	}
	
	
	
	@ApiOperation(value = "Delete Course")
	@RequestMapping(method = RequestMethod.DELETE,value = "/topics/{topicId}/courses/{id}")
	@ApiResponses(
			value = {
					@ApiResponse(code = 500, message = "Internal Server Error"),
					@ApiResponse(code = 501, message = "Internal Server Error")
			}
			)
	public void deleteCourse(@PathVariable Long id)
	{
		courseService.deleteCourse(id);
	}
}
