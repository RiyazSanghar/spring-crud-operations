package com.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.controller.dto.TopicDTO;
import com.jpa.entity.Topics;
import com.jpa.repository.TopicRepository;

@Service
public class TopicService {
	
	
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	ModelMapper modelMapper;
	

	
	public List<Topics> getAllTopics()
	{
		List<Topics> topics =new ArrayList<>();
		
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topics getTopic(Long id)
	{
		return topicRepository.findOne(id);
		
	}

	public Topics addTopic(TopicDTO topic) {
		Topics t =modelMapper.map(topic, Topics.class);
		Topics result =topicRepository.save(t);
		return result;
	}

	public Topics updateTopic(Topics topic, Long id) {
		
		
		Topics result =topicRepository.save(topic);
		return result;
		
	}

	public void deleteTopic(Long id) {
		
		topicRepository.delete(id);
		
	}
}
