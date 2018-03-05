package com.jpa;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@ComponentScan(basePackageClasses = TopicController.class)
public class CourseApiDataApplication {

	 static final Logger logger = LoggerFactory.getLogger(CourseApiDataApplication.class);

	public static void main(String[] args) {
		logger.debug("In main Method");
		SpringApplication.run(CourseApiDataApplication.class, args);
	}
	
	
	
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
