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

import com.jpa.controller.dto.TopicDTO;
import com.jpa.entity.Topics;
import com.jpa.service.TopicService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Topic Resource")
public class TopicController {

	
	@Autowired
	private TopicService topicService;
	
	
	@ApiOperation(value =  "Get All the Topics")
	@RequestMapping(value = "/topics", method = RequestMethod.GET)
	@ApiResponses(
			value = {
					@ApiResponse(code = 500, message = "Internal Server Error"),
					@ApiResponse(code = 501, message = "Internal Server Error")
			}
			)
	public ResponseEntity<List<Topics>> getAllTopics()
	{
		
		List<Topics> result = topicService.getAllTopics();
		return new ResponseEntity<List<Topics>>(result,HttpStatus.OK);
	}
	
	
	@ApiOperation(value =  "Get Topic on particular id")
	@RequestMapping(value ="/topics/{foo}", method = RequestMethod.GET)
	@ApiResponses(
			value = {
					@ApiResponse(code = 500, message = "Internal Server Error"),
					@ApiResponse(code = 501, message = "Internal Server Error")
			}
			)
	public ResponseEntity<Topics> getTopic(@PathVariable("foo") Long id)
	{
		Topics result = topicService.getTopic(id);
		return new ResponseEntity<Topics>(result,HttpStatus.OK);
	}
	
	
	@ApiOperation(value =  "Add topic")
	@RequestMapping(method = RequestMethod.POST,value = "/topics")
	@ApiResponses(
			value = {
					@ApiResponse(code = 500, message = "Internal Server Error"),
					@ApiResponse(code = 501, message = "Internal Server Error")
			}
			)
	public ResponseEntity<Topics> addTopic(@RequestBody TopicDTO topics)
	{
		Topics result =topicService.addTopic(topics);
		return new ResponseEntity<Topics>(result,HttpStatus.OK);
	}
	
	@ApiOperation(value =  "Update Topic")
	@RequestMapping(method = RequestMethod.PUT,value = "/topics/{id}")
	@ApiResponses(
			value = {
					@ApiResponse(code = 500, message = "Internal Server Error"),
					@ApiResponse(code = 501, message = "Internal Server Error")
			}
			)
	public ResponseEntity<Topics> updateTopic(@RequestBody Topics topics, @PathVariable Long id)
	{
		 Topics result = topicService.updateTopic(topics,id);
		 return new ResponseEntity<Topics>(result,HttpStatus.OK);
		 
		 
	}

	@ApiOperation(value = "Delete Topic Based On Particular ID")
	@RequestMapping(method = RequestMethod.DELETE,value = "/topics/{id}")
	@ApiResponses(
			value = {
					@ApiResponse(code = 500, message = "Internal Server Error"),
					@ApiResponse(code = 501, message = "Internal Server Error")
			}
			)
	public void deleteTopic(@PathVariable Long id)
	{
		  topicService.deleteTopic(id);
		  
	}
}
