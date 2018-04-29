package com.jpa.service;

import java.util.ArrayList;
import java.util.List;

import com.jpa.entity.Topic;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.controller.dto.TopicDTO;
import com.jpa.repository.TopicRepository;

@Service
public class TopicService {
	
	
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	ModelMapper modelMapper;
	

	
	public List<Topic> getAllTopics()
	{
		List<Topic> topics =new ArrayList<>();
		
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(Long id)
	{
		return topicRepository.findOne(id);
		
	}

	public Topic addTopic(TopicDTO topic) {
		Topic t =modelMapper.map(topic, Topic.class);
		Topic result =topicRepository.save(t);
		return result;
	}

	public Topic updateTopic(Topic topic, Long id) {
		
		
		Topic result =topicRepository.save(topic);
		return result;
		
	}

	public void deleteTopic(Long id) {
		
		topicRepository.delete(id);
		
	}
}
