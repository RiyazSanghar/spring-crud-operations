package com.jpa.service;


import com.jpa.controller.dto.SchoolSignupDTO;
import com.jpa.entity.School;
import com.jpa.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolService {



    @Autowired
    private SchoolRepository schoolRepository;

    public List<School> getAllSchools() {

        List<School> schools = new ArrayList<>();

        schoolRepository.findAll().forEach(schools::add);
        return schools;
    }

    public School addSchool(SchoolSignupDTO schoolSignupDTO) {

        School school = new School();
        school.setBusinessName(schoolSignupDTO.getSchoolName());
        school.setActivated(true);
        school.setCountry(schoolSignupDTO.getCountry());
        school.setState(schoolSignupDTO.getState());
        school.setCity(schoolSignupDTO.getCity());
        school.setAddress(schoolSignupDTO.getAddress());
        return schoolRepository.save(school);
    }

    public void deleteSchool(Long id) {

       schoolRepository.delete(id);
    }


    public School updateSchool(School school, Long id) {


        School result =schoolRepository.save(school);
        return result;

    }
}
