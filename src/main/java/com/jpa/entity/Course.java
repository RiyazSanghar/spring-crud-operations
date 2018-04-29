package com.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "COURSE")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	
	@ManyToOne
	private Topic topic;
	
	

	public Course(Long id, String name, String description, Long topicId) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId, topic.getName(), topic.getDescription());
	}
	
	public Course(){
			
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
