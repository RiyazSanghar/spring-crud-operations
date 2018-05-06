package com.jpa.controller;


import com.jpa.controller.dto.Response;
import com.jpa.controller.dto.SchoolSignupDTO;
import com.jpa.entity.School;
import com.jpa.repository.SchoolRepository;
import com.jpa.service.SchoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Rest Controller to Perform School Related Operations")
public class SchoolAccountController {

    @Autowired
    private SchoolService schoolService;


    @ApiOperation(value = "Get All the Schools")
    @RequestMapping(value = "/school", method = RequestMethod.GET)
    public ResponseEntity<Response> getAllSchools()
    {
        List<School> result = schoolService.getAllSchools();

        return new ResponseEntity<>(Response.success(result),HttpStatus.OK);
    }


    @ApiOperation(value = "Add a School")
    @RequestMapping(value = "/school",method = RequestMethod.POST)
    public ResponseEntity<Response> addSchool(@RequestBody SchoolSignupDTO schoolSignupDTO)
    {


        School result = schoolService.addSchool(schoolSignupDTO);
        return new ResponseEntity<>(Response.success(result),HttpStatus.OK);
    }


    @ApiOperation(value = "Add a School")
    @RequestMapping(value = "/school/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<School> deleteSchool(@PathVariable Long id)
    {


        schoolService.deleteSchool(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @ApiOperation("Update School Based On Particular Id")
    @RequestMapping(value = "/school/{id}", method = RequestMethod.PUT)
    public ResponseEntity<School> updateTopic(@RequestBody School school, @PathVariable Long id)
    {
        school = schoolService.updateSchool(school,id);
        return new ResponseEntity<School>(school,HttpStatus.OK);


    }


}
